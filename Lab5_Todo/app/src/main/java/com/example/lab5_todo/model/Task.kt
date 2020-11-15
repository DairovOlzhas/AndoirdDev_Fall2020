package com.example.lab5_todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey var id: Long? = null,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "status") var status: String? = null,
    @ColumnInfo(name = "category") var category: String? = null,
    @ColumnInfo(name = "duration") var duration: String? = null,
)