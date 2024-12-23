package com.example.recyclerview.domin

import di.ApiInterface
import di.Posts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class NetworkRepo(val api : ApiInterface) {

suspend fun data() : List<Posts?>?{
val res = CoroutineScope(Dispatchers.IO).async { api.fetchPost(2) }.await()
    return if (res.isSuccessful){
        listOf(res.body())
    }else{
        null
    }
}

}