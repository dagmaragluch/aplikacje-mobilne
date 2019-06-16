package com.example.todo

import android.arch.persistence.room.*

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

    @Update
    fun updateTask(task: Task)

    @Query("UPDATE TASK SET text = :text ,deadline= :deadline,image= :image, priority= :priority WHERE id LIKE :id ")
    fun updateItem(id: Int, text: String, deadline: String, image: Int, priority: Int)

}