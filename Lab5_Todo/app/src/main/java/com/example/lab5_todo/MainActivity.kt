package com.example.lab5_todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5_todo.dao.TaskDao
import com.example.lab5_todo.fragments.CreateFragment
import com.example.lab5_todo.fragments.DetailFragment
import com.example.lab5_todo.fragments.ToDoListFragment
import com.example.lab5_todo.model.Task
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_detail.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyApplication.instance.getDatabase()!!
        taskDao = db.TaskDao()

        tasks = taskDao.getAll()

        instance = this

        supportFragmentManager.beginTransaction()
            .add(R.id.container, ToDoListFragment())
            .commit()

    }

    fun onClick(view: View) {
        Log.e("Main ACtivity", "on CLick")
        when (view.id) {
            R.id.start_creating_button -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CreateFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


    companion object {
        lateinit var tasks: MutableList<Task>
        lateinit var db: AppDatabase
        lateinit var taskDao: TaskDao
        lateinit var instance: MainActivity

        fun createTask(task: Task) {
            task.id = taskDao.insert(task)
            tasks.add(task)
            instance.supportFragmentManager.popBackStack()
            printlog("create_task_button")
        }

        fun updateTask(task: Task) {
            taskDao.update(task)
            for(t in tasks){
                if (t.id == task.id){
                    t!!.status = task.status
                    t.title = task.title
                    t.description = task.description
                    t.category = task.category
                    t.duration = task.duration
                }
            }
            instance.supportFragmentManager.popBackStack()
            printlog("save_task_button")
        }

        fun deleteTask(task: Task){
            taskDao.delete(task)
        }

        fun printlog(msg: String) {
            for(t in tasks){
                Log.e(msg,  "id: ${t.id}\n Title: ${t.title};\n status: ${t.status};\n description: ${t.description};\n" +
                        " category: ${t.category};\n" +
                        " duration: ${t.duration};\n")
            }

        }
    }
}