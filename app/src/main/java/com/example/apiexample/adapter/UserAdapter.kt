package com.example.apiexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.model.UserDetails
import com.example.apiexample.model.Users

class UserAdapter(mContext:Context,val userList:ArrayList<UserDetails>):RecyclerView.Adapter<UserViewAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list, parent, false)
       return UserViewAdapter(view)
    }

    override fun onBindViewHolder(holder: UserViewAdapter, position: Int) {

        holder.tv_userId.text=userList[position].username
        holder.tv_id.text=userList[position].id.toString()
        holder.title.text=userList[position].status.toString()

       return
    }

    override fun getItemCount(): Int {

        return userList.size
    }
}

class UserViewAdapter(itemView: View):RecyclerView.ViewHolder(itemView) {


        val tv_userId=itemView.findViewById<TextView>(R.id.user_id)
        val tv_id=itemView.findViewById<TextView>(R.id.id)
    val title=itemView.findViewById<TextView>(R.id.title)

}
