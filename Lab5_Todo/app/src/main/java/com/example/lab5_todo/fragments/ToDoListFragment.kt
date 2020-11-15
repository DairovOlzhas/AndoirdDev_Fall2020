package com.example.lab5_todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5_todo.ClickListener
import com.example.lab5_todo.MainActivity
import com.example.lab5_todo.R
import com.example.lab5_todo.TaskListAdapter
import com.example.lab5_todo.model.Task
import kotlinx.android.synthetic.main.fragment_todolist.*

class ToDoListFragment: Fragment(), ClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_todolist, container, false)

        val tasklist = view.findViewById<RecyclerView>(R.id.tasks_recycle_view)
        tasklist.adapter = TaskListAdapter(view.context, this)
        tasklist.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    override fun onClickListener(task: Task) {
        this.activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailFragment(task))
            .addToBackStack(null)
            .commit()
    }

}