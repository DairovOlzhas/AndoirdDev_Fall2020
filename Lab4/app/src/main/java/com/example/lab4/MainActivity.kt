package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*
import kotlin.collections.ArrayList
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mails = ArrayList<Mail>()

        for (i in 1..9) {
            mails.add(
                Mail(
                    "Sender$i",
                    "Recipient$i",
                    Calendar.getInstance().time.toString(),
                    "Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem " +
                            "Lorem Lorem Lorem Lorem Lorem Lorem Lorem "))
        }

        val mailListAdapter = MailListAdapter(mails, this)

        val layoutManaer = LinearLayoutManager(this)


        mail_list
    }
}