package com.example.boredapp.view.start

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.boredapp.PREFERENCES_NUMBER_PARTICIPES

class StartViewModel :ViewModel(){

    private lateinit var sharedPreferences: SharedPreferences
    private val _dataValid = MutableLiveData<Boolean>()
    val dataValid :LiveData<Boolean> = _dataValid

    fun setSharedPreferences( preferences: SharedPreferences) {
        this.sharedPreferences = preferences

    }

    fun saveParticipes(participes :String) {
        if(this::sharedPreferences.isInitialized)
            sharedPreferences.edit().apply{
                putInt(PREFERENCES_NUMBER_PARTICIPES, participes.toInt())
                apply()
            }
    }

    fun dataChange(num :String){
        println(!num.isNullOrEmpty())
        //println(num.toInt() in 1..8)
        println(!num.isNullOrEmpty() && num.toInt() in 1..8)
        _dataValid.value = !num.isNullOrEmpty() && num.toInt() in 1..8
    }
}
