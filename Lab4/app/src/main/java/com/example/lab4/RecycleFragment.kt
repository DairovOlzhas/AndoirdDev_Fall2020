package com.example.lab4

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

interface ClickListener {
    fun onClickListener(mail: Mail)
}

class RecycleFragment : Fragment(), ClickListener {

    private lateinit var mails: ArrayList<Mail>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mails = ArrayList()
        for (i in 0..10) {

            val firstDate = "08/08/2019"
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            val date = formatter.parse(firstDate)
            val desiredFormat = DateTimeFormatter.ofPattern("dd, MMM yyyy").format(date)

            mails.add(
                Mail(
                    User(
                        "Olzhas",
                        "olzhas",
                        "Full name",
                        "email@com"
                    ),
                    "Title$i",
                    "Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem " +
                            "Lorem Lorem Lorem Lorem Lorem Lorem Lorem ",
                    desiredFormat,
                    true,
                    "home"
                )
            )
        }

        val view = inflater.inflate(R.layout.fragment_recycle, container, false)

        val recycleView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recycleView.adapter = MailListAdapter(mails, view.context, this)
        recycleView.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    override fun onClickListener(mail: Mail) {
        this.activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailFragment(mail))
            .addToBackStack(null)
            .commit()
    }
}