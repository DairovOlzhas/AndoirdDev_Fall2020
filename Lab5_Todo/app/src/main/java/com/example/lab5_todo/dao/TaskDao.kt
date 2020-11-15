package com.example.lab5_todo.dao

import androidx.room.*
import com.example.lab5_todo.model.Task

@Dao
interface TaskDao {
//    @Query("SELECT id, title, category, status FROM tasks")
    @Query("SELECT * FROM tasks")
    fun getAll(): MutableList<Task>

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)

    @Insert
    fun insert(task: Task): Long
}