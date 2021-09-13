package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 264XpAltlybfR3KEEi15YN:1M9cfsdCJs62JbPyLzIKYP")

    fun GetPostValue(): Call<CriptoResponse>
}