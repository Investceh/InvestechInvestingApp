package com.elifersumer.myapplication.GetOrderList.Response

class GetOrderListResponse{

    var type:String?=null
    var data:GetOrderListData?=null

    constructor(type:String,data:GetOrderListData):this(){
        this.type=type
        this.data=data

    }

    constructor()

    fun GetData():GetOrderListData?{
        return data
    }
}
