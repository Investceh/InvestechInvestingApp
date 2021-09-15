package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7aOuAn84sQ7KiY9WXjCBxY:7pzgyw2To8aJO5EwfeeB7H")

    fun GetPostValue(): Call<PariteResponse>
}