package com.elifersumer.myapplication.GetNews.Response

import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo

class GetNewsResponse {
    var result: List<News>?=null
    var success : Boolean ?= null
    constructor(result: List<News>):this(){
        this.result=result
    }

    constructor()

    fun GetData(): List<News>?{
        return result
    }
}