package com.example.todo.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.todo.DatePick
import com.example.todo.R
import java.util.*

class ToDoAddEditActivity:AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_add_edit)


    }

    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val str = String.format(Locale.JAPAN, "%d%d%d",year, monthOfYear+1, dayOfMonth)
    }

    fun showDatePickerDialog(view: View){
        val newFragment:DialogFragment = DatePick()
        newFragment.show(supportFragmentManager,"datePicker")
    }
}