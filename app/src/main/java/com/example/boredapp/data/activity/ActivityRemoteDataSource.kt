package com.example.boredapp.data.activity

import com.example.boredapp.data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityRemoteDataSource {

    fun getActivity(networkResponse: NetworkResponse<Activity>, param : String){

        val service = RetrofitServices.instance
            .create(ActivityService::class.java)
            .getActivityByUrl(param)

        /**
         * Revisar fallo cuando se le envian parametros
         */
        /*val service = when(param.lowercase()){
            "random" -> {
                RetrofitServices.instance
                    .create(ActivityService::class.java)
                    .getActivityByRandom()
            }
            else -> {
                RetrofitServices.instance
                    .create(ActivityService::class.java)
                    .getActivityByCategory(param.lowercase())

            }
        }*/

        service.enqueue(object : Callback<Activity>{
            override fun onResponse(
                call: Call<Activity>,
                response: Response<Activity>
            ) {
                val resource = response.body()?.run {
                    if (activityName.isNotEmpty() && participants > 0 && price > 0){
                        Resource(NetworkStatus.SUCCESS,this)
                    }else
                        Resource(NetworkStatus.ERROR)
                } ?: run {
                    Resource(NetworkStatus.ERROR, message = response.message())
                }

                networkResponse.onResponse(resource)
            }

            override fun onFailure(
                call: Call<Activity>,
                t: Throwable
            ) {
                networkResponse.onResponse(Resource(NetworkStatus.ERROR, message = t.message))
            }
        })
    }
}