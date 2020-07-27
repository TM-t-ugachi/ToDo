package com.example.todo

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.todo.activity.ToDoAddEditActivity
import java.util.*


class DatePick : DialogFragment(), OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        return DatePickerDialog(
            activity!!,
            activity as ToDoAddEditActivity?, year, month, day
        )
    }

    override fun onDateSet(
        view: DatePicker, year: Int,
        monthOfYear: Int, dayOfMonth: Int
    ) {
    }
}