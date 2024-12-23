package com.example.recyclerview.bottomnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var bind : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomeBinding.inflate(layoutInflater)

        return bind.root
    }

}