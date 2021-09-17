package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 1CkHMXKNJqTzJun2TIcfjR:6T7qDdxQBrjAzq5Ih5m11R")

    fun GetPostValue(): Call<PariteResponse>
}