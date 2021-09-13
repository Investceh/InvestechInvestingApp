package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 264XpAltlybfR3KEEi15YN:1M9cfsdCJs62JbPyLzIKYP")

    fun GetPostValue(): Call<PariteResponse>
}