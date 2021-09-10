package com.elifersumer.myapplication.GetCustomerPortfolio.Request

class GetCustomerPortfolioByDateParameters {

    var CustomerNo:Int?=null
    var StockDay:Int?=null
    var EndDate:String?=null

    constructor(customerNo:Int, stockDay:Int, endDate:String):this(){
        this.CustomerNo=customerNo
        this.StockDay=stockDay
        this.EndDate=endDate
    }

    constructor()
}