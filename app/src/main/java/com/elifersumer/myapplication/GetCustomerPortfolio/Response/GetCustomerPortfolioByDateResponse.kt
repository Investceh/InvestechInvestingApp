package com.elifersumer.myapplication.GetCustomerPortfolio.Response

class GetCustomerPortfolioByDateResponse {
    var type:String?=null
    var data: GetCustomerPortfolioByDateData?=null

    constructor(type:String,data: GetCustomerPortfolioByDateData):this(){
        this.type=type
        this.data=data

    }

    constructor()

    fun GetData(): GetCustomerPortfolioByDateData?{
        return data
    }
}