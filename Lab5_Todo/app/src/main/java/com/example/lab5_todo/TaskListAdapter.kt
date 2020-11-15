package com.example.lab5_todo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5_todo.model.Task

class TaskListAdapter(
    val context: Context,
    val clickListener: ClickListener
) : RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.singletask_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = MainActivity.tasks[position]
        holder.titleText.text = task.title
        holder.statusText.text = task.status
        holder.categoryText.text = task.category

        holder.itemView.setOnClickListener {
            clickListener.onClickListener(task)
        }

        holder.itemView.findViewById<Button>(R.id.delete_task_button).setOnClickListener {
            Log.e("TaskListAdapter", "delete_task")
            MainActivity.deleteTask(task)
            for(i in 0..MainActivity.tasks.size){
                if(MainActivity.tasks[i].id == task.id){
                    MainActivity.tasks.removeAt(i)
                    this.notifyItemRemoved(i)
                    break
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return MainActivity.tasks.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.task_title)
        var statusText: TextView = itemView.findViewById(R.id.task_status)
        var categoryText: TextView = itemView.findViewById(R.id.task_category)
    }
}