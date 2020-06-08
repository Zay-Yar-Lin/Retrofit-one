package com.example.retrofit_one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_one.R
import com.example.retrofit_one.model.PostItem
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(var postList : ArrayList<PostItem>):
    RecyclerView.Adapter<PostAdapter.postItemViewHolder>() {
    inner class postItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postItem: PostItem){
           itemView.txt_Post.text = postItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postItemViewHolder {
    var view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return postItemViewHolder(view)
    }

    override fun getItemCount(): Int {
    return postList.size
    }

    override fun onBindViewHolder(holder: postItemViewHolder, position: Int) {
    holder.bind(postList[position])
    }
}