package com.elifersumer.myapplication.AllCurrency.Response

import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo

class AllCurrencyResponse {
    var result: List<CurrencyInfo>?=null
    var success : Boolean ?= null
    constructor(result: List<CurrencyInfo>):this(){
        this.result=result
    }

    constructor()

    fun GetData(): List<CurrencyInfo>?{
        return result
    }
}