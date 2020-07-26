package com.example.todo.activity

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.RecyclerAdapter
import com.example.todo.RecyclerViewHolder
import com.example.todo.ToDoDBHelper
import java.util.*


class ToDoListActivity : AppCompatActivity(),RecyclerViewHolder.ItemClickListener {

    private lateinit var recyclerView:RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var arrayListId: ArrayList<Int> = arrayListOf()
    private var arrayListTitle: ArrayList<String> = arrayListOf()
    private var arrayListDeadline: ArrayList<String> = arrayListOf()

    private val dbName: String = "ToDoDB"
    private val tableName: String = "ToDoTable"
    private val dbVersion: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_list)

        insertData("testTitle","2020-07-26")
        selectData()

        viewAdapter = RecyclerAdapter(this, this, arrayListId,arrayListTitle,arrayListDeadline)
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val intent = Intent(application, ToDoAddEditActivity::class.java)
            startActivity(intent)
        }
    }

    private fun insertData(title:String,deadline:String){
        try {
            val dbHelper = ToDoDBHelper(applicationContext, "ToDoDB", null, 1)
            val database = dbHelper.writableDatabase

            val values = ContentValues()
            values.put("title",title)
            values.put("deadline", deadline)

            database.insertOrThrow(tableName, null, values)

        }catch (exception: Exception){
            Log.e("insertData", exception.toString())
        }
    }

    private fun selectData(){
        try{
            arrayListId.clear()
            arrayListTitle.clear()
            arrayListDeadline.clear()

            val dbHelper = ToDoDBHelper(applicationContext, "ToDoDB", null, 1)
            val database = dbHelper.readableDatabase

            val sql = "select id, title, deadline from " + tableName

            val cursor = database.rawQuery(sql,null)
            if(cursor.count > 0){
                cursor.moveToFirst()
                while (!cursor.isAfterLast) {
                    arrayListId.add(cursor.getInt(0))
                    arrayListTitle.add(cursor.getString(1))
                    arrayListDeadline.add(cursor.getString(2))
                    cursor.moveToNext()
                }
            }
        }catch(exception: Exception){
            Log.e("selectData", exception.toString());
        }
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }

}