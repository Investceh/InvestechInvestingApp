package com.elifersumer.myapplication.LiveBorsa.Response

import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateData

class LiveBorsaResponse {

    var result: List<StockInfo>?=null
    var success : Boolean ?= null
    constructor(result: List<StockInfo>):this(){
        this.result=result
    }

    constructor()

    fun GetData(): List<StockInfo>?{
        return result
    }
}