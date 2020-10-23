package com.example.lab4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment(val mail: Mail) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        (view.findViewById(R.id.sender_name) as TextView).text = mail.sender.fullName
        (view.findViewById(R.id.sender_email) as TextView).text = mail.sender.email
        (view.findViewById(R.id.send_date) as TextView).text = mail.date
        (view.findViewById(R.id.starred) as CheckBox).isChecked = mail.starred
        (view.findViewById(R.id.mail_title) as TextView).text = mail.title
        (view.findViewById(R.id.mail_body) as TextView).text = mail.body


        return view
    }
}

