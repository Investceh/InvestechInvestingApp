package com.elifersumer.myapplication.GetCustomerPortfolio.Response

class GetCustomerPortfolioByDateResponse {
    var Type:String?=null
    var Data: GetCustomerPortfolioByDateData?=null

    constructor(type:String,data: GetCustomerPortfolioByDateData):this(){
        this.Type=type
        this.Data=data

    }

    constructor()

    fun GetData(): GetCustomerPortfolioByDateData?{
        return Data
    }
}