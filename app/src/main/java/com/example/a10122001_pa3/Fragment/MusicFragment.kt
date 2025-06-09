package com.example.a10122001_pa3.Fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10122001_pa3.Adapter.MusicAdapter
import com.example.a10122001_pa3.Model.MusicItem
import com.example.a10122001_pa3.R

class MusicFragment : Fragment() {
    private lateinit var videoView: VideoView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMusic)
        val musicList = listOf(
            MusicItem(R.drawable.ic_music, "NIKI Low Key", R.raw.niki_lowkey),
            MusicItem(R.drawable.ic_music, "NIKI La La Lost You", R.raw.niki_la_la_lost_you),
            MusicItem(
                R.drawable.ic_music, "NIKI You'II Be In My Heart",
                R.raw.niki_youii_be_in_my_heart
            )
        )


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MusicAdapter(musicList)

        videoView = view.findViewById(R.id.videoView)

        // Ambil video dari raw
        val videoUri = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.spongebob_squarepants}")
        videoView.setVideoURI(videoUri)

        // Tambahkan Media Controller
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Mulai play
//        videoView.start()

    }

}
