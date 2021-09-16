package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7JuyF8usMCVDm4jksgZ72E:1a61wbqF21lUjswsOcILZ4")

    fun GetPostValue(): Call<LiveBorsaResponse>

}