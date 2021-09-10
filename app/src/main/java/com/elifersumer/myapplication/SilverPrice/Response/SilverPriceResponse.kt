package com.elifersumer.myapplication.SilverPrice.Response

import com.elifersumer.myapplication.GoldPrice.Response.GoldInfo

class SilverPriceResponse {
    var result: SilverInfo?=null
    var success : Boolean ?= null
    constructor(result: SilverInfo):this(){
        this.result=result
    }

    constructor()

    fun GetData(): SilverInfo?{
        return result
    }
}