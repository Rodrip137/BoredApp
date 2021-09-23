package com.example.boredapp.view.home

import androidx.recyclerview.widget.RecyclerView
import com.example.boredapp.databinding.ItemActivityBinding

class HomeviewHolder(private val binding : ItemActivityBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : String, listener: RecyclerviewClickListener){
        with(binding){
            tvTittle.text = item
            root.setOnClickListener { listener.onRecyclerViewItemClick(item)}
        }
    }
}