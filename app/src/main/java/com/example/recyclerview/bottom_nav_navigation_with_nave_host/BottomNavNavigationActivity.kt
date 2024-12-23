package com.example.recyclerview.bottom_nav_navigation_with_nave_host

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityBottomNavNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavNavigationActivity : AppCompatActivity() {
    private lateinit var bind :ActivityBottomNavNavigationBinding
    private lateinit var container : FragmentContainerView
    private lateinit var nav : BottomNavigationView
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityBottomNavNavigationBinding.inflate(layoutInflater)
        setContentView(bind.root)
        container = bind.fragmentContainerView
        nav = bind.bottomNav
        navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()!!

        setupWithNavController(nav, navController)


    }
}