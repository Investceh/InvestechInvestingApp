package com.elifersumer.myapplication.Cripto.Response

class CriptoResponse {
    var result: List<CriptoInfo>?=null
    var success : Boolean ?= null
    constructor(result: List<CriptoInfo>):this(){
        this.result=result
    }

    constructor()

    fun GetData(): List<CriptoInfo>?{
        return result
    }
}