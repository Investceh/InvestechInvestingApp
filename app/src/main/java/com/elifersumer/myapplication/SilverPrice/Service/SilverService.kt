package com.elifersumer.myapplication.SilverPrice.Service

import com.elifersumer.myapplication.SilverPrice.Response.SilverPriceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SilverService {
    @GET("economy/silverPrice")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 2Vu0SR2nyy8UB3MumXXj9z:0CTQqQA6LsVYD0ZGqifhlo")

    fun GetPostValue(): Call<SilverPriceResponse>
}