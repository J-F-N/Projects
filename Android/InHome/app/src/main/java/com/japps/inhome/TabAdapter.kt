package com.japps.inhome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter( fa : FragmentActivity) : FragmentStateAdapter(fa){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> TabWeeklyFragment()
            else -> TabDateFragment()
        }
    }
}