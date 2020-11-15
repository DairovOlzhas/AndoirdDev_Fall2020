package com.example.lab5_todo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.lab5_todo.MainActivity
import com.example.lab5_todo.R
import com.example.lab5_todo.model.Task
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment(val task: Task): Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        view.findViewById<TextInputLayout>(R.id.edit_title).editText!!.setText(task.title)
        view.findViewById<TextInputLayout>(R.id.edit_description).editText!!.setText(task.description)
        view.findViewById<TextInputLayout>(R.id.edit_category).editText!!.setText(task.category)
        view.findViewById<TextInputLayout>(R.id.edit_status).editText!!.setText(task.status)
        view.findViewById<TextInputLayout>(R.id.edit_duration).editText!!.setText(task.duration)

        view.findViewById<Button>(R.id.save_task_button).setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        Log.e("DetailFragment", "onClick")
        when(v!!.id){
            R.id.save_task_button -> {
                val updatedTask = Task()
                updatedTask.title = edit_title.editText!!.text.toString()
                updatedTask.status = edit_status.editText!!.text.toString()
                updatedTask.description = edit_description.editText!!.text.toString()
                updatedTask.category = edit_category.editText!!.text.toString()
                updatedTask.duration = edit_duration.editText!!.text.toString()
                updatedTask.id = task.id
                MainActivity.updateTask(updatedTask)
            }
        }
    }
}