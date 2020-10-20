package com.example.lesson5

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter(val users: ArrayList<User>, val context: Context): RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_view, parent, false)
        Log.e("UserListAdapter","onCreateViewHolder")
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users[position]
        holder.nameText.text = user.name
        holder.positionText.text = user.position
        Log.e("UserListAdapter","onBindViewHolder")
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameText: TextView = itemView.findViewById(R.id.name)
        var positionText: TextView = itemView.findViewById(R.id.position)
    }
}