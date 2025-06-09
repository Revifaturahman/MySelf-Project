package com.example.a10122001_pa3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.media.MediaPlayer
import com.example.a10122001_pa3.Model.MusicItem
import com.example.a10122001_pa3.R


class MusicAdapter(private val musicList: List<MusicItem>) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false // Flag untuk mengecek apakah lagu sedang diputar atau tidak
    private var currentPlayingPosition: Int = -1



    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val musicImage: ImageView = itemView.findViewById(R.id.musicImage)
        val musicTitle: TextView = itemView.findViewById(R.id.musicTitle)
        val btnPlay: ImageButton = itemView.findViewById(R.id.btnPlay)
        val btnNext: ImageButton = itemView.findViewById(R.id.btnNext)
        val btnPrevious: ImageButton = itemView.findViewById(R.id.btnPrevious)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = musicList[position]
        holder.musicImage.setImageResource(music.imageResId)
        holder.musicTitle.text = music.title

        // Set tombol Play/Pause sesuai status
        if (position == currentPlayingPosition && isPlaying) {
            holder.btnPlay.setImageResource(R.drawable.ic_pause)
        } else {
            holder.btnPlay.setImageResource(R.drawable.ic_play)
        }

        // Tombol Play
        holder.btnPlay.setOnClickListener {
            val currentPos = holder.adapterPosition
            if (currentPos != RecyclerView.NO_POSITION) {
                val music = musicList[currentPos]

                if (currentPlayingPosition == currentPos && isPlaying) {
                    mediaPlayer?.pause()
                    isPlaying = false
                    holder.btnPlay.setImageResource(R.drawable.ic_play)
                    Toast.makeText(holder.itemView.context, "Paused: ${music.title}", Toast.LENGTH_SHORT).show()
                } else {
                    mediaPlayer?.release()
                    mediaPlayer = MediaPlayer.create(holder.itemView.context, music.rawResId)
                    mediaPlayer?.start()
                    isPlaying = true
                    currentPlayingPosition = currentPos
                    notifyDataSetChanged() // Perbarui semua ViewHolder (penting!)
                    Toast.makeText(holder.itemView.context, "Playing: ${music.title}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Tombol Next
        holder.btnNext.setOnClickListener {
            val nextPos = (position + 1) % musicList.size
            val nextMusic = musicList[nextPos]
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(holder.itemView.context, nextMusic.rawResId)
            mediaPlayer?.start()
            isPlaying = true
            currentPlayingPosition = nextPos
            notifyDataSetChanged() // agar ikon Play/Pause di-refresh
            Toast.makeText(holder.itemView.context, "Playing: ${nextMusic.title}", Toast.LENGTH_SHORT).show()
        }

        // Tombol Previous
        holder.btnPrevious.setOnClickListener {
            val prevPos = if (position - 1 < 0) musicList.size - 1 else position - 1
            val prevMusic = musicList[prevPos]
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(holder.itemView.context, prevMusic.rawResId)
            mediaPlayer?.start()
            isPlaying = true
            currentPlayingPosition = prevPos
            notifyDataSetChanged() // agar ikon Play/Pause di-refresh
            Toast.makeText(holder.itemView.context, "Playing: ${prevMusic.title}", Toast.LENGTH_SHORT).show()
        }
    }



    override fun getItemCount() = musicList.size
}
