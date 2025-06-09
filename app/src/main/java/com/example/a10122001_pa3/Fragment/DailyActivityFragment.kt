package com.example.a10122001_pa3.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10122001_pa3.Adapter.DailyActivityAdapter
import com.example.a10122001_pa3.Adapter.FriendsActivityAdapter
import com.example.a10122001_pa3.Model.ActivityItem
import com.example.a10122001_pa3.Model.FriendItem
import com.example.a10122001_pa3.R

class DailyActivityFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DailyActivityAdapter
    private lateinit var recyclerFriends: RecyclerView
    private lateinit var friendAdapter: FriendsActivityAdapter
    private val dailyList = listOf(
        ActivityItem(R.drawable.ic_sun, "Bangun Pagi"),
        ActivityItem(R.drawable.ic_eat, "Sarapan"),
        ActivityItem(R.drawable.ic_school, "Kuliah"),
        ActivityItem(R.drawable.ic_book, "Belajar"),
        ActivityItem(R.drawable.ic_group, "Maen Sama Temen"),
        ActivityItem(R.drawable.ic_sport, "Maen Futsal"),
        ActivityItem(R.drawable.ic_moon, "Tidur")
    )

    private val friendList = listOf(
        FriendItem(R.drawable.barol, "Baros"),
        FriendItem(R.drawable.fadil, "Fadil"),
        FriendItem(R.drawable.hilmy, "Hilmy"),
        FriendItem(R.drawable.danu, "Danu"),
        FriendItem(R.drawable.zaidan, "Zaidan"),
        FriendItem(R.drawable.umam, "Umam"),
        FriendItem(R.drawable.tijar, "Tijar"),
        FriendItem(R.drawable.abil, "Abil"),
        FriendItem(R.drawable.dhafin, "Dafin")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_daily_activity, container, false)
        recyclerView = view.findViewById(R.id.recyclerDaily)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = DailyActivityAdapter(dailyList)
        recyclerView.adapter = adapter

        // RecyclerView untuk Friend List
        recyclerFriends = view.findViewById(R.id.recyclerFriends)
        recyclerFriends.layoutManager = LinearLayoutManager(context)
        friendAdapter = FriendsActivityAdapter(friendList)
        recyclerFriends.adapter = friendAdapter
        return view
    }
}
