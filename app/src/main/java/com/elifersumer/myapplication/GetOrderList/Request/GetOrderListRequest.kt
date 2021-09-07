package com.elifersumer.myapplication.GetOrderList.Request

class GetOrderListRequest {
    var header: com.elifersumer.myapplication.GetOrderList.Request.Header?=null
    var parameters:GetOrderListParameters?=null

        constructor(header: com.elifersumer.myapplication.GetOrderList.Request.Header, parameters: GetOrderListParameters):this(){
            this.header=header
            this.parameters=parameters
        }

        constructor()
    }

