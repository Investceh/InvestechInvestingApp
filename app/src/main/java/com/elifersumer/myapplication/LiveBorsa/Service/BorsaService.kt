package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Request.LiveBorsaRequest
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaData
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @POST("liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 2Vu0SR2nyy8UB3MumXXj9z:0CTQqQA6LsVYD0ZGqifhlo")

    fun GetPostValue(@Body request: LiveBorsaRequest): Call<LiveBorsaResponse>

}