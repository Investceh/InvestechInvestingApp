package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 264XpAltlybfR3KEEi15YN:1M9cfsdCJs62JbPyLzIKYP")

    fun GetPostValue(): Call<LiveBorsaResponse>

}