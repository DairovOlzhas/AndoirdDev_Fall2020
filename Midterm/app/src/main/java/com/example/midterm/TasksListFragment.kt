package com.example.midterm

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


interface ClickListener {
    fun onClickListener(data: Task)
}

class TasksListFragment : Fragment(), ClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasks_list, container, false)

        val recycleview = view.findViewById(R.id.recycleview) as RecyclerView
        recycleview.adapter = TaskListAdapter(MainActivity.tasks, view.context, this)
        recycleview.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    override fun onClickListener(task: Task) {
        Log.e("TaskDetailFragment", "oncreat" + task.description)
        this.activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.task_container, TaskDetailFragment(task))
            .addToBackStack(null)
            .commit()
    }

}