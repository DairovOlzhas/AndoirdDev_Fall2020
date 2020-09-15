package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {  

    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "OnCreate")
        num1.setOnClickListener { view ->
            counter++
            result.text = counter.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity","OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity","OnRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity","OnStop")
    }

    override fun onDestroy() {
        Log.e("MainActivity", "OnDestroy")
        super.onDestroy()
    }
}