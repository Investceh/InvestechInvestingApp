package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 1CkHMXKNJqTzJun2TIcfjR:6T7qDdxQBrjAzq5Ih5m11R")

    fun GetPostValue(): Call<CriptoResponse>
}