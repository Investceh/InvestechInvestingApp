package com.elifersumer.myapplication.Parite.Response

class PariteResponse {
    var result: List<PariteInfo>?=null
    var success : Boolean ?= null
    constructor(result: List<PariteInfo>):this(){
        this.result=result
    }

    constructor()

    fun GetData(): List<PariteInfo>?{
        return result
    }
}