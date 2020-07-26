package com.example.todo
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ToDoDBHelper(context: Context, databaseName:String,factory: SQLiteDatabase.CursorFactory?, version: Int) :SQLiteOpenHelper(context,databaseName,factory,version){

    override fun onCreate(database: SQLiteDatabase?){
        database?.execSQL("drop table ToDoTable")
        database?.execSQL("create table if not exists ToDoTable(id integer primary key autoincrement, title text, deadline text)")
    }

    override fun onUpgrade(database: SQLiteDatabase?,oldVersion: Int, newVersion: Int) {
        if(oldVersion < newVersion){
            database?.execSQL("alter table ToDoTable add column deleteFlag integer default 0")
        }
    }

}