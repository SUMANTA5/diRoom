package com.sumanta.roomdi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sumanta.roomdi.R
import com.sumanta.roomdi.model.User

class UserAdapter
constructor(
    private val context: Context,
    private var userList:ArrayList<User>)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ivam_view,parent,false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=userList[position]
        holder.name.text=user.name
        holder.age.text=user.age.toString()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView =itemView.findViewById(R.id.name1)
        val age:TextView=itemView.findViewById(R.id.age1)
    }

    fun setUser(userList: ArrayList<User>){
        this.userList=userList
        notifyDataSetChanged()
    }
}