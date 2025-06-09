package com.example.a10122001_pa3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10122001_pa3.Model.ActivityItem
import com.example.a10122001_pa3.R

class DailyActivityAdapter(private val activities: List<ActivityItem>) :
    RecyclerView.Adapter<DailyActivityAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.iconActivity)
        val text: TextView = view.findViewById(R.id.textActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]
        holder.icon.setImageResource(activity.iconResId)
        holder.text.text = activity.title
    }

    override fun getItemCount(): Int = activities.size
}
