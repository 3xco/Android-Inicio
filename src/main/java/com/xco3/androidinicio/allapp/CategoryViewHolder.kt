package com.xco3.androidinicio.allapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.xco3.androidinicio.R

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val tvCategories: TextView = view.findViewById(R.id.tvCategories)
    private val divider: View = view.findViewById(R.id.divider)
    private val itcCategories: CardView= view.findViewById(R.id.itcCategories)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){
        val color = if (taskCategory.isSelected){
            R.color.todo_background_card
        }else {
            R.color.todo_background_disabled
        }
        itcCategories.setCardBackgroundColor(ContextCompat.getColor(itcCategories.context, color))
        itemView.setOnClickListener{onItemSelected(layoutPosition)}

        when (taskCategory){
            TaskCategory.Business -> {
                tvCategories.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvCategories.text = "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )
            }
            TaskCategory.Personal -> {
                tvCategories.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )
            }
        }
    }
}