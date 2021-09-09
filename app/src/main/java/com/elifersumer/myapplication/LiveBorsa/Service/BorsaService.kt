package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Request.LiveBorsaRequest
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers


interface BorsaService {
    @GET("liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 2Vu0SR2nyy8UB3MumXXj9z:0CTQqQA6LsVYD0ZGqifhlo")

    fun GetPostValue(): Call<LiveBorsaResponse>

}