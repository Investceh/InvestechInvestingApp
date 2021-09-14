package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 3LlZtUPIgvJK86FZqJ1FSU:1MCpf8Yh8O33slepO2Uc80")

    fun GetPostValue(): Call<PariteResponse>
}