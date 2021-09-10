package com.elifersumer.myapplication.GetOrderList.Request

class GetOrderListParameters{
    var CustomerNo:Int?=null
    var OrderTrackType:Int?=null

    constructor(CustomerNo:Int,OrderTrackType:Int):this(){
        this.CustomerNo=CustomerNo
        this.OrderTrackType=OrderTrackType
    }

    constructor()
}

