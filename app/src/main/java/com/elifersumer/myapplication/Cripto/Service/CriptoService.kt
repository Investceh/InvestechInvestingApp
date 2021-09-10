package com.elifersumer.myapplication.Cripto.Service

import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CriptoService {
    @GET("economy/cripto")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 0fjIQHRZBNJw5S2w2oOjHx:0FJeOyjGz7ZdzG1tbQ4PUr")

    fun GetPostValue(): Call<CriptoResponse>
}