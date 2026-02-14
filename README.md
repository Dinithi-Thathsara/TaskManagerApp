 Task Manager App - Android Assignment 03
 App Description
This is a simple yet functional Task Management application built using **Kotlin** and **Android Studio**. The app allows users to add, view, and delete tasks or notes locally. It focuses on clean UI design, proper state management, and basic data persistence.

Key Features:
* Add Tasks: Users can enter text into an input field and save it to a list.
* View Tasks: A `RecyclerView` is used to display the list of tasks efficiently.
* Delete Tasks: Each task item has a dedicated delete button to remove it from the list.
* Data Persistence: Tasks are saved locally using `SharedPreferences`, so they remain even after the app is restarted.


 Screenshots

1. Main Screen**: 
<img width="1916" height="1022" alt="Add task" src="https://github.com/user-attachments/assets/e698b6e6-30aa-4059-8216-949a2f1608ac" />

2. Adding a Task: 
<img width="1913" height="1022" alt="Saved task" src="https://github.com/user-attachments/assets/51ebb2c9-f51d-4a55-b18c-24713f23fda8" />

3. Deleting a Task: 

<img width="1920" height="1025" alt="Delete task" src="https://github.com/user-attachments/assets/2d0251f4-04d4-4961-9661-3e8bbef714a4" />

Design Choices & Architecture

 1. Architecture: ViewModel
I implemented the **ViewModel** pattern to handle **State Management**. This ensures that the list of tasks is preserved during configuration changes, such as screen rotations, preventing data loss for the user.
2. UI Polish & Spacing
* RecyclerView: Used for efficient list rendering instead of a simple ListView.
* Custom Layout: A custom `item_task.xml` was created to provide **proper spacing (12dp padding)** and a clean look for each task entry.
* Meaningful Labels: Used clear hints like "Enter your task" to improve user experience.

3. Secure Coding Practices
* Input Validation: Before saving a task, the app checks if the input is blank to prevent storing empty or invalid data.
* Secure Storage**: Data is stored using `Context.MODE_PRIVATE` in `SharedPreferences`, ensuring that the saved tasks are only accessible by this specific application.

 How to Run
1. Clone this repository.
2. Open the project in Android Studio.
3. Build and Run the app on an emulator or physical device (API 26+ recommended).
