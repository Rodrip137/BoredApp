package com.example.boredapp.data.activity

import com.example.boredapp.data.NetworkResponse

class ActivityRepository constructor(private val remoteDataSource: ActivityRemoteDataSource) {

    fun getActivity(networkResponse : NetworkResponse<Activity>, param : String){
        return remoteDataSource.getActivity(networkResponse, param)
    }
}