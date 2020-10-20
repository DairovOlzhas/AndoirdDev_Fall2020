package com.example.lesson5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val userJson = sharedPreferences.getString("user", "")

        if(userJson?.isNotEmpty()!!) {
            val user = Gson().fromJson(userJson, User::class.java)
        }

//        if (user != null) {
//            Log.d("username", user.name)
//        }

        val users = ArrayList<User>()

        for (i in 1..50) {
            users.add(User("Name$i","", "Position", 20 + i))
        }

        val userListAdapter = UserListAdapter(users, this)

        val layoutManager = LinearLayoutManager(this)

        recycleview.layoutManager = layoutManager
        recycleview.adapter = userListAdapter
    }
}