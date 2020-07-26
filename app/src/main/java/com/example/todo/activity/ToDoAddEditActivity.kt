package com.example.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R

class ToDoAddEditActivity:AppCompatActivity(){

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_add_edit)
    }
}