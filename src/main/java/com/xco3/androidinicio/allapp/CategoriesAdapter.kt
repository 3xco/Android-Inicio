package com.xco3.androidinicio.allapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xco3.androidinicio.R

class CategoriesAdapter(
    private val categories: List<TaskCategory>,
    private val onItemSelected: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    //crea una vista para que el segundo metodo pase la info
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoryViewHolder(view)
    }

    //introduce la info en la vista creada anteriormente
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

    //esta funcion devuelve la cantidad de elementos en la lista
    override fun getItemCount(): Int = categories.size

}