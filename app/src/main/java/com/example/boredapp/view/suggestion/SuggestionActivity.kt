package com.example.boredapp.view.suggestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.boredapp.R
import com.example.boredapp.data.NetworkStatus
import com.example.boredapp.databinding.ActivitySuggestionBinding

class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding
    private val viewModel : SuggestionViewModel by viewModels( factoryProducer = { SuggestionViewModelFactory() })
    private lateinit var item : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent?.extras
        item = bundle?.getString("category").toString()

        val url = when(item?.lowercase()){
            "random" -> {
                "/api/activity"
            }
            else -> {
                "/api/activity?type=${item?.lowercase()}"
            }
        }

        viewModel.getActivity(url)

        with(binding){
            include.ivRandom.visibility = View.INVISIBLE
            include.ivBack.visibility = View.VISIBLE

            include.ivBack.setOnClickListener { onBackPressed() }

            btnTryAnother.setOnClickListener { viewModel.getActivity(url) }
        }

        setObservers()
    }

    private fun setObservers() {

        viewModel.activity.observe(this, Observer {

            binding.progressBar.isVisible = it.status == NetworkStatus.LOADING

            when (it.status) {
                NetworkStatus.SUCCESS -> {
                    with(binding){
                        with(it.data){

                            include.tvCategory.text = if (item.lowercase() == "random") item else this?.category

                            lnContent.visibility = View.VISIBLE
                            tvSubTittle.text = this?.activityName
                            tvNumParticipants.text = this?.participants.toString()
                            tvValPrice.text = this?.price.toString()

                            if(item.lowercase() == "random"){
                                tvValCategory.text = this?.category
                                rlCategory.visibility = View.VISIBLE
                            }
                            else
                                rlCategory.visibility = View.INVISIBLE
                        }
                    }
                }
                NetworkStatus.ERROR -> {
                    with(binding){
                        btnTryAnother.visibility = View.INVISIBLE
                        include.tvCategory.text = ""
                        lnContent.visibility = View.INVISIBLE
                        tvSubTittle.text = ""
                        lnError.visibility = View.VISIBLE
                        tvError.text = it.message ?: getString(R.string.home_error)
                    }
                }
            }
        })

    }
}