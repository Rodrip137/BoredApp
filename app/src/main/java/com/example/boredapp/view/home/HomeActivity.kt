package com.example.boredapp.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.boredapp.R
import com.example.boredapp.databinding.ActivityHomeBinding
import com.example.boredapp.view.suggestion.SuggestionActivity

class HomeActivity : AppCompatActivity(), RecyclerviewClickListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter : HomeAdapter
    private val itemActivities = listOf("Education", "Recreational", "Social", "DIY", "Charity", "Cooking", "Relaxation", "Music", "Busywork")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.root)

        binding.toolbar.tvCategory.text = getString(R.string.activities)

        binding.toolbar.ivRandom.setOnClickListener {
            onRecyclerViewItemClick("Random")
        }

        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = HomeAdapter(itemActivities, this)
        binding.rvActivities.adapter = adapter
    }

    override fun onRecyclerViewItemClick(item: String) {
        //Toast.makeText(this, "Clicked at $item", Toast.LENGTH_LONG).show()

        val intent = Intent(this, SuggestionActivity::class.java)
        intent.putExtra("category", item)
        startActivity(intent)
    }

}