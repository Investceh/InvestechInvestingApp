package com.elifersumer.myapplication.GoldPrice.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import com.elifersumer.myapplication.GoldPrice.Response.GoldPriceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GoldService {
    @GET("economy/goldPrice")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 2Vu0SR2nyy8UB3MumXXj9z:0CTQqQA6LsVYD0ZGqifhlo")

    fun GetPostValue(): Call<GoldPriceResponse>
}