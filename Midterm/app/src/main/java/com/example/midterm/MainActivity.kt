package com.example.midterm

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_add_task.*

class MainActivity : AppCompatActivity(){

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var taskCreateFragment: TaskCreateFragment

    companion object {
        lateinit var tasks: ArrayList<Task>
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasks = ArrayList()
        taskCreateFragment = TaskCreateFragment()
        sharedPreferences = getSharedPreferences("tasks", Context.MODE_PRIVATE)
        for (key in sharedPreferences.all.keys) {
            val taskJson = sharedPreferences.getString(key, "")
            if (taskJson!!.isNotEmpty()) {
                val task = Gson().fromJson(taskJson, Task::class.java)
                Log.e("JSON", "$task")
                if (task.title.isNotEmpty()){
                    tasks.add(task)
                }
            }
        }

        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.task_container, TasksListFragment())
            .commit()

    }

    @SuppressLint("CommitPrefEdits")
    fun onClick(view: View) {
        when (view.id) {
            R.id.createtask -> {
                var parent = view.parent as View
                var title = parent.findViewById<EditText>(R.id.edittitle)
                var description = parent.findViewById<EditText>(R.id.editdescription)
                var status = parent.findViewById<EditText>(R.id.editstatus)
                var category = parent.findViewById<EditText>(R.id.editcategory)
                var duration = parent.findViewById<EditText>(R.id.editduration)
                var allFilled = true
                if (title.text.isEmpty()) {
                    edittitle.setError("Title could not be empty!")
                    allFilled = false
                }
                if (description.text.isEmpty()) {
                    editdescription.setError("Description could not be empty!")
                    allFilled = false
                }
                if (status.text.isEmpty()) {
                    editstatus.setError("Status could not be empty!")
                    allFilled = false
                }
                if (category.text.isEmpty()) {
                    editcategory.setError("Category could not be empty!")
                    allFilled = false
                }
                if (duration.text.isEmpty()) {
                    editduration.setError("Duration could not be empty!")
                    allFilled = false
                }

                if (!allFilled) return
                val task = Task(
                    tasks.size,
                    title.text.toString(),
                    description.text.toString(),
                    status.text.toString(),
                    category.text.toString(),
                    duration.text.toString()
                )
                title.setText("")
                description.setText("")
                status.setText("")
                category.setText("")
                duration.setText("")
                tasks.add(task)

                val taskJson = Gson().toJson(task)
                val editor = sharedPreferences.edit()
                editor.putString(task.id.toString(), taskJson)
                editor.apply()

                supportFragmentManager.beginTransaction()
                    .replace(R.id.task_container, TasksListFragment())
                    .commit()

                supportFragmentManager.popBackStack()
            }
            R.id.addtask -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.task_container, taskCreateFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}


