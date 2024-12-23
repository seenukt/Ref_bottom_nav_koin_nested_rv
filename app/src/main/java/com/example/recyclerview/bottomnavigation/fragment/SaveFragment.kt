package com.example.recyclerview.bottomnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.databinding.FragmentSaveBinding


class SaveFragment : Fragment() {

    private lateinit var binding: FragmentSaveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaveBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

}