package com.example.lab5_todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.lab5_todo.MainActivity
import com.example.lab5_todo.R
import com.example.lab5_todo.model.Task
import kotlinx.android.synthetic.main.fragment_create.*

class CreateFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create, container, false)
        view.findViewById<Button>(R.id.create_task_button).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.create_task_button -> {
                val task = Task()
                task.title = create_title.editText!!.text.toString()
                task.status = create_status.editText!!.text.toString()
                task.description = create_description.editText!!.text.toString()
                task.category = create_category.editText!!.text.toString()
                task.duration = create_duration.editText!!.text.toString()
                MainActivity.createTask(task)
            }
        }
    }
}