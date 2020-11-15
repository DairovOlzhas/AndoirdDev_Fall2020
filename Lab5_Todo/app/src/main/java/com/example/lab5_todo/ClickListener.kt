package com.example.lab5_todo

import android.view.View
import com.example.lab5_todo.model.Task

interface ClickListener {
    fun onClickListener(task: Task)
}