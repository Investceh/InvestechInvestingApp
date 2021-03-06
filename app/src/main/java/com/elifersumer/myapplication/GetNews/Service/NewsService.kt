package com.elifersumer.myapplication.GetNews.Service

import com.elifersumer.myapplication.GetNews.Response.GetNewsResponse
import com.elifersumer.myapplication.GoldPrice.Response.GoldPriceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsService {
    @GET("news/getNews?country=tr&tag=economy")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 7JuyF8usMCVDm4jksgZ72E:1a61wbqF21lUjswsOcILZ4")


    fun GetPostValue(): Call<GetNewsResponse>
}