package com.example.boredapp.data.activity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ActivityService {

    @GET("/api/activity?type{category}")
    fun getActivityByCategory(@Path(value = "category", encoded = true) type : String) : Call<Activity>

    @GET("api/activity/")
    fun getActivityByRandom() : Call<Activity>

    @GET
    fun getActivityByUrl(@Url url : String) : Call<Activity>
}