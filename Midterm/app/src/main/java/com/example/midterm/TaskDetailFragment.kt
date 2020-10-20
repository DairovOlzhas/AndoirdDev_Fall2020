package com.example.midterm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_detail_task.*

class TaskDetailFragment(val task: Task) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_task, container, false)

        (view.findViewById(R.id.taskid) as TextView).text = task.id.toString()
        (view.findViewById(R.id.tasktitle) as TextView).text = task.title
        (view.findViewById(R.id.taskdescription) as TextView).text = task.description
        (view.findViewById(R.id.taskstatus) as TextView).text = task.status
        (view.findViewById(R.id.taskcategory) as TextView).text = task.category
        (view.findViewById(R.id.taskduration) as TextView).text = task.duration
        Log.e("TaskDetailFragment", "oncreat" + this.task.description)
        return view
    }
}