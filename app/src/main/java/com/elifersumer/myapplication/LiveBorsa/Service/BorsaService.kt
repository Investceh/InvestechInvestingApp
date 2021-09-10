package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 1Rz59l3JPvufvbR2WwOXhZ:2fipoIKo3RuYiTnteQDRDK")

    fun GetPostValue(): Call<LiveBorsaResponse>

}