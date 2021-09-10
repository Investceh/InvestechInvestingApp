package com.elifersumer.myapplication.Parite.Service

import com.elifersumer.myapplication.Parite.Response.PariteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DövizService {
    @GET("economy/parite")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 0fjIQHRZBNJw5S2w2oOjHx:0FJeOyjGz7ZdzG1tbQ4PUr")

    fun GetPostValue(): Call<PariteResponse>
}