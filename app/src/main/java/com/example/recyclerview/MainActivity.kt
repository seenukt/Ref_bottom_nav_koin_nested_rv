package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    lateinit var mainAdapter : MainAdapter

    val vm : MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainAdapter = MainAdapter({
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        },{
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
         val rv = binding.rv
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.adapter = mainAdapter

//        adapter.submitList(data())


    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch{
            vm.getData()
        }
        vm._data.observe(this){
            mainAdapter.submitList(it)
        }

    }

    fun data() : MutableList<MainData>{
        val list = mutableListOf<MainData>()
        for(i in 1..12){
            list.add(MainData("month$i", mutableListOf("details${i + 1}", "details${i + 2}", "details${i + 3}","details${i + 4}")))
        }
        return list
    }
}