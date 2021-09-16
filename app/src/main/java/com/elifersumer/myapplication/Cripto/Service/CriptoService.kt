package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7JuyF8usMCVDm4jksgZ72E:1a61wbqF21lUjswsOcILZ4")

    fun GetPostValue(): Call<CriptoResponse>
}