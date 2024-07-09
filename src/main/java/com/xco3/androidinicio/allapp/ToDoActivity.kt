package com.xco3.androidinicio.allapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.test.isSelected
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xco3.androidinicio.R
import com.xco3.androidinicio.allapp.TaskCategory.*

class ToDoActivity : AppCompatActivity() {

    private val categories = listOf(
        Personal,
        Business,
        Other
    )

    private val tasks = mutableListOf(
        Task("Prueba B", Business),
        Task("Prueba P", Personal),
        Task("Prueba O", Other)
    )

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_to_do)
        initComponent()
        initUi()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_tasks)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.txtTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedID = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedID)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_Business) -> Business
                    getString(R.string.todo_Personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTask()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategory = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUi() {
        categoriesAdapter = CategoriesAdapter(categories) {updateCategory(it)}
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoriesAdapter

        taskAdapter = TasksAdapter(tasks){onItemSelected(it)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelecter = !tasks[position].isSelecter
        updateTask()
    }

    private fun updateCategory(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }

    private fun updateTask() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }
}