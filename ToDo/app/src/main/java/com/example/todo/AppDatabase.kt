package com.example.todo

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database( entities = [(Task::class)], version = 1,  exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDAO
}