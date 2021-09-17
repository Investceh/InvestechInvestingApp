package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 1CkHMXKNJqTzJun2TIcfjR:6T7qDdxQBrjAzq5Ih5m11R")

    fun GetPostValue(): Call<LiveBorsaResponse>

}