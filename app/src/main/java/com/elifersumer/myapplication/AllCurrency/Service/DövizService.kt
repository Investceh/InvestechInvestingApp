package com.elifersumer.myapplication.AllCurrency.Service

import com.elifersumer.myapplication.AllCurrency.Response.AllCurrencyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/allCurrency")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 2Vu0SR2nyy8UB3MumXXj9z:0CTQqQA6LsVYD0ZGqifhlo")

    fun GetPostValue(): Call<AllCurrencyResponse>
}