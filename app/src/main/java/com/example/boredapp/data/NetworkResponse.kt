package com.example.boredapp.data

interface NetworkResponse<T> {

    fun onResponse(value : Resource<T>)

}
