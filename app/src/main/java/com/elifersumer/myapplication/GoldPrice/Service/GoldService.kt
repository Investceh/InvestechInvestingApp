package com.elifersumer.myapplication.GoldPrice.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import com.elifersumer.myapplication.GoldPrice.Response.GoldPriceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GoldService {
    @GET("economy/goldPrice")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 3LlZtUPIgvJK86FZqJ1FSU:1MCpf8Yh8O33slepO2Uc80")

    fun GetPostValue(): Call<GoldPriceResponse>
}