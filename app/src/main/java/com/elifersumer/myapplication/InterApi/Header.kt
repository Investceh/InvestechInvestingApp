package com.elifersumer.myapplication.InterApi

class Header {

    var AppKey:String?=null
    var Channel:String?=null
    var ChannelSessionId:String?=null
    var ChannelRequestId:String?=null
    constructor(AppKey:String,Channel:String,ChannelSessionId:String,ChannelRequestId:String):this(){
        this.AppKey = AppKey
        this.Channel = Channel
        this.ChannelSessionId = Channel
        this.ChannelRequestId = Channel
    }

    constructor()
}