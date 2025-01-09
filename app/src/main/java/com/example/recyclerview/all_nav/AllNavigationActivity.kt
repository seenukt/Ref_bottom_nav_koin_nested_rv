package com.example.recyclerview.all_nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityAllNavigationBinding

class AllNavigationActivity : AppCompatActivity() {

    lateinit var binding : ActivityAllNavigationBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer2) as NavHostFragment
        navController = navHostFragment.navController

    }
}