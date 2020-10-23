package com.example.lab4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("my preferences", Context.MODE_PRIVATE)
        val userJson = sharedPreferences.getString("user", "")
        if (userJson!!.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View) {
        val username = username_edit.text.toString()
        val password = password_edit.text.toString()
        val email = email_edit.text.toString()
        val fullName = full_name_edit.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()){
            val user = User(username, password, fullName, email)

            val editor = sharedPreferences.edit()

            val userJson = Gson().toJson(user)
            editor.putString("user", userJson)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}