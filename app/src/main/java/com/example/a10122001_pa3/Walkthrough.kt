package com.example.a10122001_pa3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.a10122001_pa3.Adapter.OnboardingAdapter

class Walkthrough : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)

        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        btnNext.setOnClickListener {
            val isLastPage = viewPager.currentItem == adapter.itemCount - 1
            if (isLastPage) {
                val intent = Intent(this, MainActivity::class.java) // Ganti dengan halaman utama kamu
                startActivity(intent)
                finish()
            } else {
                viewPager.currentItem += 1
            }
        }

        btnPrev.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem -= 1
            }
        }

        // Optional: disable tombol saat di halaman pertama/terakhir
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                btnPrev.isEnabled = position != 0
                btnNext.text = if (position == adapter.itemCount - 1) "Mulai" else "Next"

            }
        })
    }
}