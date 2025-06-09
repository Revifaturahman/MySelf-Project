package com.example.a10122001_pa3.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a10122001_pa3.Fragment.OnboardingFragment

class OnboardingAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3 // Jumlah layar onboarding
    }

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment.newInstance(position)
    }
}