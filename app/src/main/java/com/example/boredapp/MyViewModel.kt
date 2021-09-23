package com.example.boredapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel() {

    private val _showTerms = MutableLiveData<Boolean?>()
    val showTerms : MutableLiveData<Boolean?> = _showTerms

    fun startShowTerms() {
        _showTerms.value = true
    }

    fun endShowTerms(){
        _showTerms.value = null
    }

}
