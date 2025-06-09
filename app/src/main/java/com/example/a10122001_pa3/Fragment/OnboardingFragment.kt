package com.example.a10122001_pa3.Fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a10122001_pa3.R

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private lateinit var imageView: ImageView
    private lateinit var descriptionText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.imageView)
        descriptionText = view.findViewById(R.id.descriptionText)

        // Menampilkan konten sesuai dengan posisi di ViewPager
        val position = arguments?.getInt("position") ?: 0
        setupOnboardingContent(position)
    }

    private fun setupOnboardingContent(position: Int) {
        when (position) {
            0 -> {
                imageView.setImageResource(R.drawable.img_wt1)
                descriptionText.text = "\"Setiap inovasi besar dimulai dari kolaborasi sederhana. Ketika ide dan kode bersatu, terciptalah awal dari perubahan besar.\"."
            }
            1 -> {
                imageView.setImageResource(R.drawable.img_wt4)
                descriptionText.text = "\"Teknologi bukan sekadar alat, tetapi jembatan yang menghubungkan imajinasi dengan kenyataan—memberi kemudahan, keindahan, dan makna dalam setiap sentuhan.\""
            }
            2 -> {
                imageView.setImageResource(R.drawable.img_wt6)
                descriptionText.text = "\"Apa yang kita bangun hari ini, menentukan dunia yang kita tinggali esok hari. Gunakan teknologi untuk memberi dampak, bukan sekadar jejak.\""
            }
        }
    }

    companion object {
        fun newInstance(position: Int): OnboardingFragment {
            val fragment = OnboardingFragment()
            val bundle = Bundle()
            bundle.putInt("position", position)
            fragment.arguments = bundle
            return fragment
        }
    }
}