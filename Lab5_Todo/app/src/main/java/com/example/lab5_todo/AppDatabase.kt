package com.example.lab5_todo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab5_todo.dao.TaskDao
import com.example.lab5_todo.model.Task

@Database(
    entities = arrayOf(
        Task::class,
    ), version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TaskDao(): TaskDao
}
