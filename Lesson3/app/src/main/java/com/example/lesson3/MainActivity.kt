package com.example.lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var status = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.first_fragment_container, FirstFragment())
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.second_fragment_container, SecondFragment())
            .addToBackStack("initial")
            .commit()

    }

    fun onClick(view: View) {
//        if (status == 0) {
//            supportFragmentManager.beginTransaction()
//                .add(R.id.second_fragment_container, ThirdFragment())
//                .commit()
//            status = 1
//        }else{
//            status = 0
//            supportFragmentManager.popBackStack("initial", 0)
//        }

        val intent = Intent(this, )
    }
}