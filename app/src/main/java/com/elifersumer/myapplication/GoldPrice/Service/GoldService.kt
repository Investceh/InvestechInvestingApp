package com.elifersumer.myapplication.GoldPrice.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import com.elifersumer.myapplication.GoldPrice.Response.GoldPriceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GoldService {
    @GET("economy/goldPrice")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7aOuAn84sQ7KiY9WXjCBxY:7pzgyw2To8aJO5EwfeeB7H")

    fun GetPostValue(): Call<GoldPriceResponse>
}