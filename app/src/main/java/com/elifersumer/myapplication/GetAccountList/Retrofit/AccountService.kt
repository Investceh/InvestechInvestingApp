package com.elifersumer.myapplication.GetAccountList.Retrofit

import com.elifersumer.myapplication.GetAccountList.Request.GetAccountListRequest
import com.elifersumer.myapplication.GetAccountList.Response.GetAccountListResponse
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetOrderCustomerPortfolioByDateRequest
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AccountService {
    @POST("Accounts/GetAccountList")
    @Headers("Content-Type: application/json",
        "Ocp-Apim-Subscription-Key: fb4de3b2ef414379b294c25a867e405f")

    fun GetPostValue(@Body request: GetAccountListRequest): Call<GetAccountListResponse>
}