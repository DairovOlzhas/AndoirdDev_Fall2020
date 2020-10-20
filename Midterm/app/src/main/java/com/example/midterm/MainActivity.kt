package com.example.midterm

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.fragment_tasks_list.*


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setContentView(R.layout.fragment_tasks_list)

//        sharedPreferences = getSharedPreferences("tasks", Context.MODE_PRIVATE)
//        val tasksJson = sharedPreferences.getStringSet("tasks", null)
//
//        if(tasksJson?.isNotEmpty()!!) {
//            val myType = object : TypeToken<ArrayList<Task>>() {}.type
//            val tasks = Gson().fromJson<ArrayList<Task>>(tasksJson, myType)
//        }
//
        supportFragmentManager.beginTransaction()
            .add(R.id.task_container, TasksListFragment())
            .commit()


    }

    fun onClick(view: View) {
        when (view.tag) {
            "createTask" -> {
                view.tag = "addTask"

//                tasks.add(Task())
            }
            "addTask" -> {
                view.tag = "createTask"
                supportFragmentManager.beginTransaction()
                    .add(R.id.task_container, TaskCreateFragment())
                    .commit()
            }
            "detailTask" -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.task_container, TaskDetailFragment())
                    .commit()

            }
        }
    }
}


