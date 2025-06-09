package com.example.a10122001_pa3.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a10122001_pa3.R
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class ProfileFragment : Fragment() {

    private lateinit var map:MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout-nya dulu
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Baru cari ID map dari view yang sudah di-inflate
        map = view.findViewById(R.id.map)
        val noText = view.findViewById<TextView>(R.id.no_text)
        val igText = view.findViewById<TextView>(R.id.ig_text)
        map.setMultiTouchControls(true)

        // Koordinat Bandung
        val startPoint = GeoPoint(-6.914744, 107.609810)
        map.controller.setZoom(15.0)
        map.controller.setCenter(startPoint)

        // Marker
        val marker = Marker(map)
        marker.position = startPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Bandung"
        map.overlays.add(marker)

//        dial telpon
        noText.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + noText.text.toString())
            startActivity(intent)
        }

//        Instagram
        igText.text = "@revifaturahman05"
        igText.setOnClickListener {
            val url = "https://www.instagram.com/revifaturahman05/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        return view
    }


    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}