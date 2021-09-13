package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 25sP2i4nwsIxz5VmfaUAx5:3FW29xqWj2YLYdWAHXw2mJ")

    fun GetPostValue(): Call<PariteResponse>
}