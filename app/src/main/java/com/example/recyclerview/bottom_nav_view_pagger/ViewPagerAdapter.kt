package com.example.recyclerview.bottom_nav_view_pagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val fragmentActivity: FragmentActivity, private val list: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}