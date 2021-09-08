package com.elifersumer.myapplication.GetCustomerPortfolio.Retrofit

import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetOrderCustomerPortfolioByDateRequest
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetroService {
    @POST("stocks/GetCustomerPortfolioByDate")
    @Headers("Content-Type: application/json",
        "Ocp-Apim-Subscription-Key: fb4de3b2ef414379b294c25a867e405f")

    fun GetPostValue(@Body request: GetOrderCustomerPortfolioByDateRequest): Call<GetCustomerPortfolioByDateResponse>

}