package com.example.recyclerview.all_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityComponentBinding

class ComponentActivity : AppCompatActivity() {

    lateinit var binding : ActivityComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentBinding.inflate(layoutInflater)
        binding.progressCircular.progress = 30
        setContentView(binding.root)
    }
}