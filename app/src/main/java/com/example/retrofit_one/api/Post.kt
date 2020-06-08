package com.example.retrofit_one.api


import com.example.retrofit_one.model.PostItem
import retrofit2.Call
import retrofit2.http.GET

interface Post {
    @GET("/posts/")
    fun getTitle(): Call<List<PostItem>>
}