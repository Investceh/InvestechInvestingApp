package com.elifersumer.myapplication.GetAccountList.Request

import com.elifersumer.myapplication.Header

class GetAccountListRequest {
    var header: Header?=null
    var parameters: List<GetAccountListParameters>?=null

    constructor(header: Header, parameters: List<GetAccountListParameters>):this(){
        this.header=header
        this.parameters=parameters
    }

    constructor()
}