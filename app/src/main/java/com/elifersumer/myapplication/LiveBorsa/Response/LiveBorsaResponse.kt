package com.elifersumer.myapplication.LiveBorsa.Response

import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateData

class LiveBorsaResponse {

    var result: LiveBorsaData?=null

    constructor(result: LiveBorsaData):this(){
        this.result=result
    }

    constructor()

    fun GetData(): LiveBorsaData?{
        return result
    }
}