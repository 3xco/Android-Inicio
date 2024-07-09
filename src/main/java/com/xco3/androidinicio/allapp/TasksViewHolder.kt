package com.xco3.androidinicio.allapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.xco3.androidinicio.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTasks: TextView = view.findViewById(R.id.tvTasks)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task) {
        if (task.isSelecter) {
            tvTasks.paintFlags = tvTasks.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTasks.paintFlags = tvTasks.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        tvTasks.text = task.name
        cbTask.isChecked = task.isSelecter
        val color = when (task.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Personal -> R.color.todo_personal_category
            else -> R.color.todo_other_category
        }

        cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, color)
        )

    }

}