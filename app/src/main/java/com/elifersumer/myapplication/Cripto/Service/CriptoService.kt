package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 3LlZtUPIgvJK86FZqJ1FSU:1MCpf8Yh8O33slepO2Uc80")

    fun GetPostValue(): Call<CriptoResponse>
}