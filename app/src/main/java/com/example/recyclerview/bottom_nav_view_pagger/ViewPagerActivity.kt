package com.example.recyclerview.bottom_nav_view_pagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.recyclerview.R
import com.example.recyclerview.bottomnavigation.fragment.HomeFragment
import com.example.recyclerview.bottomnavigation.fragment.ProfileFragment
import com.example.recyclerview.bottomnavigation.fragment.SaveFragment
import com.example.recyclerview.databinding.ActivityViewPaggerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPaggerBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var nav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPaggerBinding.inflate(layoutInflater)
        viewPager = binding.viewPager
        nav = binding.bottomNav

       viewPager.adapter = ViewPagerAdapter(this, listOf(HomeFragment(),SaveFragment(),ProfileFragment()))
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0->{
                        nav.selectedItemId = R.id.home
                    }
                    1->{nav.selectedItemId = R.id.save}
                    2->{nav.selectedItemId = R.id.person}
                }
                super.onPageSelected(position)

            }

        })

        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                   viewPager.currentItem = 0
                    return@setOnItemSelectedListener true
                }

                R.id.save -> {
                    viewPager.currentItem = 1
                    return@setOnItemSelectedListener true
                }

                R.id.person -> {
                    viewPager.currentItem = 2
                    return@setOnItemSelectedListener true
                }
            }

            return@setOnItemSelectedListener false
        }

        setContentView(binding.root)
    }
}