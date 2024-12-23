package com.example.recyclerview.curved

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.get
import androidx.navigation.ui.setupWithNavController
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityBottomNavNavigationBinding
import com.example.recyclerview.databinding.ActivityCurvedBottomNavBinding
import prefs.UserPrefs

class CurvedBottomNavActivity : AppCompatActivity() {

    lateinit var binding: ActivityCurvedBottomNavBinding

    val prefs = UserPrefs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurvedBottomNavBinding.inflate(layoutInflater)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        Log.d("seenu", "onCreate:${prefs.name}")
        prefs.name = "Seenu"
        Toast.makeText(this, prefs.name, Toast.LENGTH_SHORT).show()
        setContentView(binding.root)

    }
}