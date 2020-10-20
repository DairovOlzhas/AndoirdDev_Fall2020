package com.example.midterm

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(val tasks: ArrayList<Task>, val context: Context): RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = tasks[position]
        holder.titleText.text = task.title
        holder.statusText.text = task.status
        holder.categoryText.text = task.category
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.tasktitle)
        var statusText: TextView = itemView.findViewById(R.id.status)
        var categoryText: TextView = itemView.findViewById(R.id.category)
    }
}