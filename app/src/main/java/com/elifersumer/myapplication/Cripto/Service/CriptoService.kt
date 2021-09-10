package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 6eA35Vhd0GQudHYdc0O7Mb:0xyjo6Y7bUdJiOUissbaE7")

    fun GetPostValue(): Call<CriptoResponse>
}