package com.example.boredapp.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boredapp.databinding.ItemActivityBinding

class HomeAdapter(
    private val data : List<String>,
    private val listener : RecyclerviewClickListener
) : RecyclerView.Adapter<HomeviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = ItemActivityBinding.inflate(inflater, parent, false)
        return HomeviewHolder(item)
    }

    override fun onBindViewHolder(holder: HomeviewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int = data.size


}