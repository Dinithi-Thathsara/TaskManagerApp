package com.example.myapplication
import android.content.Context
import com.example.myapplication.TaskViewModel
import com.example.myapplication.TaskAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TaskViewModel
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val editText = findViewById<EditText>(R.id.editTextTask)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // RecyclerView Setup [cite: 17]
        adapter = TaskAdapter(viewModel.tasks.value!!) { position ->
            viewModel.removeTask(position)
            adapter.notifyDataSetChanged()
            saveData() //
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //  Save data [cite: 20, 30]
        btnSave.setOnClickListener {
            val taskName = editText.text.toString()

            /* SECURE CODING PRACTICE 1: Input Validation [cite: 45, 46
            */
            if (taskName.isNotBlank()) {
                viewModel.addTask(taskName)
                adapter.notifyDataSetChanged()
                saveData()
                editText.text.clear()
            } else {
                Toast.makeText(this, "Please enter a task!", Toast.LENGTH_SHORT).show()
            }
        }

        loadData() //
    }

    fun addTask(taskName: String) {}

    /* SECURE CODING PRACTICE 2: Data Storage Consideration [cite: 45, 46]

    */
    private fun saveData() {
        val sharedPref = getSharedPreferences("UserTasks", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val taskSet = viewModel.tasks.value?.map { it.title }?.toSet()
        editor.putStringSet("tasks_key", taskSet)
        editor.apply() // Local persistence [cite: 33]
    }

    private fun loadData() {
        val sharedPref = getSharedPreferences("UserTasks", Context.MODE_PRIVATE)
        val savedTasks = sharedPref.getStringSet("tasks_key", emptySet())
        savedTasks?.forEach { title ->
            viewModel.addTask(title)
        }
        adapter.notifyDataSetChanged()
    }
}