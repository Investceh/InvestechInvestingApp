package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7aOuAn84sQ7KiY9WXjCBxY:7pzgyw2To8aJO5EwfeeB7H")

    fun GetPostValue(): Call<CriptoResponse>
}