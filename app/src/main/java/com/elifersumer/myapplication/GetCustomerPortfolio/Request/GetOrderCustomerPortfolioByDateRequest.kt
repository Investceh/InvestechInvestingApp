package com.elifersumer.myapplication.GetCustomerPortfolio.Request

import com.elifersumer.myapplication.Header

class GetOrderCustomerPortfolioByDateRequest {
    var header: Header?=null
    var parameters: List<GetCustomerPortfolioByDateParameters>?=null

    constructor(header: Header, parameters: List<GetCustomerPortfolioByDateParameters>):this(){
        this.header=header
        this.parameters=parameters
    }

    constructor()
}