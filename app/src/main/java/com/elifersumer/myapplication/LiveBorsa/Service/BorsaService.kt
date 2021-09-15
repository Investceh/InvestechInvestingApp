package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7aOuAn84sQ7KiY9WXjCBxY:7pzgyw2To8aJO5EwfeeB7H")

    fun GetPostValue(): Call<LiveBorsaResponse>

}