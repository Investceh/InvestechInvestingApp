package com.elifersumer.myapplication.GetOrderList.Retrofit

import com.elifersumer.myapplication.GetOrderList.Request.GetOrderListRequest
import com.elifersumer.myapplication.GetOrderList.Response.GetOrderListResponse
import retrofit2.Call
import retrofit2.http.*

interface RetroService {

    @POST("stocks/GetOrderList")
    @Headers("Content-Type: application/json",
        "Ocp-Apim-Subscription-Key: fb4de3b2ef414379b294c25a867e405f")

    fun GetPostValue(@Body request: GetOrderListRequest): Call<GetOrderListResponse>


}