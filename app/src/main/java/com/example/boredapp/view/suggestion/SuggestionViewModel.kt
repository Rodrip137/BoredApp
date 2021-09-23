package com.example.boredapp.view.suggestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.boredapp.data.*
import com.example.boredapp.data.activity.Activity
import com.example.boredapp.data.activity.ActivityRepository

class SuggestionViewModel constructor( private val repository: ActivityRepository) : ViewModel() {

    private var _activity = MutableLiveData<Resource<Activity>>()
    val activity : LiveData<Resource<Activity>>
        get() = _activity

    fun getActivity(category : String) {
        _activity.value = Resource(NetworkStatus.LOADING)
        val response = object  : NetworkResponse<Activity>{
            override fun onResponse(value: Resource<Activity>) {
                _activity.value = value
            }
        }

        repository.getActivity(response, category)
    }


}