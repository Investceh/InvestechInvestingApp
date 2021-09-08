package com.elifersumer.myapplication.GetCustomerPortfolio.Request

import com.elifersumer.myapplication.Header

class GetOrderCustomerPortfolioByDateRequest {
    var header: Header?=null
    var parameters: GetCustomerPortfolioByDateParameters?=null

    constructor(header: Header, parameters: GetCustomerPortfolioByDateParameters):this(){
        this.header=header
        this.parameters=parameters
    }

    constructor()
}