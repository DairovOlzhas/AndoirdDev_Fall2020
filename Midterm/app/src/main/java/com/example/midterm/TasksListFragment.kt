package com.example.midterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TasksListFragment : Fragment() {
    private lateinit var tasks: ArrayList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasks_list, container, false)

        tasks = ArrayList<Task>()

        for (i in 1..9) {
            tasks.add(Task(i, "Title$i", "Description$i", "status$i", "category$i", "$i"))
        }

        val taskListAdapter = TaskListAdapter(tasks, view.context)
//
        val recycleview = view.findViewById(R.id.recycleview) as RecyclerView
        recycleview.adapter = taskListAdapter

        recycleview.layoutManager = LinearLayoutManager(view.context)
//

        return view
    }
}