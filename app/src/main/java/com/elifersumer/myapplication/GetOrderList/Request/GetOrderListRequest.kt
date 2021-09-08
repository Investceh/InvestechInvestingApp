package com.elifersumer.myapplication.GetOrderList.Request

import com.elifersumer.myapplication.Header

class GetOrderListRequest {
    var header: Header?=null
    var parameters:List<GetOrderListParameters>?=null

        constructor(header: Header, parameters: List<GetOrderListParameters>):this(){
            this.header=header
            this.parameters=parameters
        }

        constructor()
    }

