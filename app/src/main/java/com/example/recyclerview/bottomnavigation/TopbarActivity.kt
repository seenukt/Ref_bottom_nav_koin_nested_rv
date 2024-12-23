package com.example.recyclerview.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityTopbarBinding
import com.example.recyclerview.bottomnavigation.fragment.HomeFragment
import com.example.recyclerview.bottomnavigation.fragment.ProfileFragment
import com.example.recyclerview.bottomnavigation.fragment.SaveFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TopBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopbarBinding
    private val homeFrag by lazy { HomeFragment() }
    private val saveFrag by lazy { SaveFragment() }
    private val profileFrag by lazy { ProfileFragment() }
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var frame: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopbarBinding.inflate(layoutInflater)

        bottomNav = binding.nv
        frame = binding.fragment
//        bottomNav.selectedItemId = R.id.home
        changeFragment(homeFrag)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    changeFragment(homeFrag)
                    return@setOnItemSelectedListener true
                }

                R.id.save -> {
                    changeFragment(saveFrag)
                    return@setOnItemSelectedListener true
                }

                R.id.person -> {
                    changeFragment(profileFrag)
                    return@setOnItemSelectedListener true
                }
            }

            return@setOnItemSelectedListener false
        }
        setContentView(binding.root)
    }

    private fun changeFragment(fragment: Any) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment as Fragment)
            .commit()
    }

}