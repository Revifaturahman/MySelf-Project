package com.example.a10122001_pa3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10122001_pa3.Model.FriendItem
import com.example.a10122001_pa3.R

class FriendsActivityAdapter(private val friendList: List<FriendItem>) :
    RecyclerView.Adapter<FriendsActivityAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friendImage: ImageView = itemView.findViewById(R.id.friendImage)
        val friendName: TextView = itemView.findViewById(R.id.friendName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_item, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val item = friendList[position]
        holder.friendName.text = item.name
        holder.friendImage.setImageResource(item.imageResId)
    }

    override fun getItemCount() = friendList.size
}
