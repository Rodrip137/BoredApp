package com.example.boredapp.view.suggestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.boredapp.data.activity.ActivityRemoteDataSource
import com.example.boredapp.data.activity.ActivityRepository

class SuggestionViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val remoteDataSource = ActivityRemoteDataSource()
        val repository = ActivityRepository(remoteDataSource)

        return SuggestionViewModel(repository) as T
    }
}