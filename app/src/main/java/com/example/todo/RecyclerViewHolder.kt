package com.example.todo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener{
        fun onItemClick(view: View, position:Int)
    }

    val todoTitle: TextView = view.findViewById(R.id.ToDoTitle)
    val todoDeadline: TextView = view.findViewById(R.id.ToDoDeadline)

    init{

    }
}