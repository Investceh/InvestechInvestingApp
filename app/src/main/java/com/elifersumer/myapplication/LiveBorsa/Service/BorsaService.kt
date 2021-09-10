package com.elifersumer.myapplication.LiveBorsa.Service

import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import retrofit2.Call
import retrofit2.http.*


interface BorsaService {
    @GET("economy/liveBorsa")
    @Headers("Content-Type: application/json",
        "Authorization: apikey 0CvbuAMbduN4SLfrJPRit7:1dysKrpPeZaYvSRjgTaDcH")

    fun GetPostValue(): Call<LiveBorsaResponse>

}