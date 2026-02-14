package com.example.myapplication
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel class to manage UI-related data in a lifecycle-conscious way

class TaskViewModel : ViewModel() {
    val tasks = MutableLiveData<MutableList<Task>>(mutableListOf())

    fun addTask(title: String) {
        val currentList = tasks.value ?: mutableListOf()
        currentList.add(Task(System.currentTimeMillis(), title))
        tasks.value = currentList
    }

    fun removeTask(position: Int) {
        // Get current task list
        val currentList = tasks.value ?: mutableListOf()
        // Remove task at given index
        currentList.removeAt(position)
        tasks.value = currentList
    }
}