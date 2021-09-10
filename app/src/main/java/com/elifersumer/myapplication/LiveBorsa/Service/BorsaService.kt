package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 0fjIQHRZBNJw5S2w2oOjHx:0FJeOyjGz7ZdzG1tbQ4PUr")

    fun GetPostValue(): Call<LiveBorsaResponse>

}