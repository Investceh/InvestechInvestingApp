package com.elifersumer.myapplication.GoldPrice.Response


class GoldPriceResponse {
    var result: List<GoldInfo>?=null
    var success : Boolean ?= null
    constructor(result: List<GoldInfo>):this(){
        this.result=result
    }

    constructor()

    fun GetData(): List<GoldInfo>?{
        return result
    }
}