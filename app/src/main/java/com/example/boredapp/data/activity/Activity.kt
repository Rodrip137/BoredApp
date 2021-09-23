package com.example.boredapp.data.activity

import com.google.gson.annotations.SerializedName

data class Activity(
    @SerializedName("activity") val activityName : String,
    @SerializedName("accessibility") val accessibility : Float,
    @SerializedName("type") val category : String,
    @SerializedName("participants") val participants : Int,
    @SerializedName("price") val price : Float,
    @SerializedName("link") val link : String?,
    @SerializedName("key") val key : String?
)
