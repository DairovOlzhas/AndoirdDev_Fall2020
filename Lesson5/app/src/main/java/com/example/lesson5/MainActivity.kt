package com.example.lesson5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val users = ArrayList<User>()

        for (i in 1..9) {
            users.add(User("Name$i", "Position", 20 + i))
        }


    }
}