package com.example.lab4

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailListAdapter(val mails: ArrayList<Mail>, val context: Context): RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mail = mails[position]
        holder.senderText.text = mail.sender
        holder.recipientText.text = mail.recipient
        Log.e("UserListAdapter","onBindViewHolder")
    }

    override fun getItemCount(): Int {
        return mails.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var senderText: TextView = itemView.findViewById(R.id.sender_name)
        var recipientText: TextView = itemView.findViewById(R.id.recipient)
    }
}