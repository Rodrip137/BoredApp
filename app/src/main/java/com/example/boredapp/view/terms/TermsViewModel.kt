package com.example.boredapp.view.terms

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.boredapp.TERMS_ACCEPTED

class TermsViewModel :ViewModel(){

    private lateinit var sharedPreferences: SharedPreferences
    private val _termsAccepted = MutableLiveData<Boolean>()
    val termsAccepted :LiveData<Boolean> = _termsAccepted

    fun setSharedPreferences( preferences: SharedPreferences) {
        this.sharedPreferences = preferences
    }

    fun isTermsAccepted(state :Boolean) {
        if(this::sharedPreferences.isInitialized)
            sharedPreferences.edit().apply{
                putBoolean(TERMS_ACCEPTED, state)
                apply()
            }
    }

    fun checkBoxStatus( isChecked :Boolean){
        if (isChecked) _termsAccepted.value = true
    }

}
