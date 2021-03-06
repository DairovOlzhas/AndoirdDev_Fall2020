package com.example.lab4

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailListAdapter(
    val mails: ArrayList<Mail>,
    val context: Context,
    val clickListener: ClickListener
): RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mail = mails[position]
        holder.senderNameText.text = mail.sender.fullName
        holder.senderEmailText.text = mail.sender.email
        holder.mailDateText.text = mail.date


        holder.itemView.setOnClickListener {
            clickListener.onClickListener(mail)
        }
        Log.e("UserListAdapter","onBindViewHolder")
    }

    override fun getItemCount(): Int {
        return mails.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var senderNameText: TextView = itemView.findViewById(R.id.sender_name)
        var senderEmailText: TextView = itemView.findViewById(R.id.sender_email)
        var mailDateText: TextView = itemView.findViewById(R.id.send_date)
    }
}