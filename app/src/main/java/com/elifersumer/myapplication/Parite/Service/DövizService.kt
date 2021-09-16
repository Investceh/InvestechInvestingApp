package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7JuyF8usMCVDm4jksgZ72E:1a61wbqF21lUjswsOcILZ4")

    fun GetPostValue(): Call<PariteResponse>
}