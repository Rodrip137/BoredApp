package com.example.boredapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boredapp.databinding.ActivityMainBinding
import android.R
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.example.boredapp.databinding.FragmentTermsBinding
import com.example.boredapp.view.home.HomeActivity


class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var _preferences :SharedPreferences
    val preferences get() = initializePreferences()

    override fun onCreate(savedInstanceState: Bundle?) {

        //setTheme(R.style.Wid)

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun startHome(){
        val home = Intent(this, HomeActivity::class.java)
        startActivity(home)
    }

    fun initializePreferences() :SharedPreferences{
        _preferences = getSharedPreferences(
            DATA_BOREDAPP,
            Context.MODE_PRIVATE
        )
        return _preferences
    }

}