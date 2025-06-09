package com.example.a10122001_pa3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a10122001_pa3.Fragment.DailyActivityFragment
import com.example.a10122001_pa3.Fragment.GalleryFragment
import com.example.a10122001_pa3.Fragment.HomeFragment
import com.example.a10122001_pa3.Fragment.MusicFragment
import com.example.a10122001_pa3.Fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

//NAMA: REVI FATURAHMAN
//NIM: 10122001
//KELAS: PEMROGRAMAN ANDROID 3
//TANGGAL : MULAI DARI 1 ATAU 2 BULAN KEBELAKANG

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Default fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, HomeFragment())
            .commit()

        navView.setOnItemSelectedListener {
            val selectedFragment = when (it.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_daily -> DailyActivityFragment()
                R.id.nav_gallery -> GalleryFragment()
                R.id.nav_music -> MusicFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> HomeFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, selectedFragment)
                .commit()

            true
        }
    }
}