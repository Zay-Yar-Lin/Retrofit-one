package com.example.retrofit_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_one.adapter.PostAdapter
import com.example.retrofit_one.api.Post
import com.example.retrofit_one.model.PostItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPost()
    }
    fun getPost(){
        var baseUrl = "https://jsonplaceholder.typicode.com"
        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService = retrofit.create(Post::class.java)
        var apiCall = retrofitService.getTitle()
        apiCall.enqueue(object : Callback<List<PostItem>>{
            override fun onFailure(call: Call<List<PostItem>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<PostItem>>,
                response: Response<List<PostItem>>
            ) {
                val postList=response.body()
                Log.d("response>>>>>",postList.toString())
                val Adapter = PostAdapter(postList as ArrayList<PostItem>)

                Post_Recycler.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = Adapter
                }

            }
        })
    }
}