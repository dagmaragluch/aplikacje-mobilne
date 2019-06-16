package com.example.todo

//import java.util.*
//
//data class Task (var text: String, var deadline: /*Date*/String, var image: Int, var priority: Int)


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @ColumnInfo(name = "text") var text: String,
    @ColumnInfo(name = "deadline") var deadline: String,
    @ColumnInfo(name = "image") var image: Int,
    @ColumnInfo(name = "priority") var priority: Int,
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id : Long = 0
)