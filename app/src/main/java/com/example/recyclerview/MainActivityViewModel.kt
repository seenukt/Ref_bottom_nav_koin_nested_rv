package com.example.recyclerview

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview.domin.NetworkRepo

class MainActivityViewModel(val repo : NetworkRepo) : ViewModel() {

    private val data = MutableLiveData<List<MainData>>()
    val _data:LiveData<List<MainData>> get() = data


    suspend fun getData() {
        if(repo.data()?.isNotEmpty() == true){data.postValue(data())}
    }

    private  fun data() : List<MainData>{
        val list = mutableListOf<MainData>()
        for(i in 1..12){
            list.add(MainData("month$i", mutableListOf("details${i + 1}", "details${i + 2}", "details${i + 3}","details${i + 4}")))
        }
        return list
    }

}