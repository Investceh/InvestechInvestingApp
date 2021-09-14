package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 3LlZtUPIgvJK86FZqJ1FSU:1MCpf8Yh8O33slepO2Uc80")

    fun GetPostValue(): Call<LiveBorsaResponse>

}