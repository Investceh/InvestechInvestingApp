package com.elifersumer.myapplication.GetAccountList.Response

import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateData

class GetAccountListResponse {
    var Type:String?=null
    var Data: GetAccountListData?=null

    constructor(type:String,data: GetAccountListData):this(){
        this.Type=type
        this.Data=data

    }

    constructor()

    fun GetData(): GetAccountListData?{
        return Data
    }
}