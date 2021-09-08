package com.elifersumer.myapplication.GetOrderList.Response

class GetOrderListData{

    var WaitingOrders:List<Order>?=null
    var DoneOrders:List<Order>?=null
    var FutureOrders:List<Order>?=null
    var ChainOrders:List<Order>?=null
    var ErrorCode:String?=null

    constructor(waitingOrders:List<Order>, doneOrders:List<Order>, futureOrders:List<Order>):this(){
        this.WaitingOrders=waitingOrders
        this.DoneOrders=doneOrders
        this.FutureOrders=futureOrders
    }

    constructor()
}
