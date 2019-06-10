package com.example.todo

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TaskDAO {
    @Query("select * from task")
    fun getAll(): List<Task>

    @Insert
    fun insertAll(vararg task: Task)

    @Insert
    fun insertTask(task: Task)


    @Delete
    fun deleteTask(task: Task)
}