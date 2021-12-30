package com.example.apiexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.model.Users

class UserAdapter(val userList:ArrayList<Users>):RecyclerView.Adapter<UserViewAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list, parent, false)
       return UserViewAdapter(view)
    }

    override fun onBindViewHolder(holder: UserViewAdapter, position: Int) {
      //  holder.tv_language.setText(userList.get(position).get)

       return
    }

    override fun getItemCount(): Int {

        return userList.size
    }
}

class UserViewAdapter(itemView: View):RecyclerView.ViewHolder(itemView) {

        val tv_language=itemView.findViewById<TextView>(R.id.accept_lang)
        val tv_email=itemView.findViewById<TextView>(R.id.email)
        val tv_password=itemView.findViewById<TextView>(R.id.password)
        val tv_userId=itemView.findViewById<TextView>(R.id.user_id)
        val tv_deviceToken=itemView.findViewById<TextView>(R.id.device_token)

}
