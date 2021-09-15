package com.elifersumer.myapplication.Database

class WaitingOrder {
    var Id:Int? = null
    var Hisse:String?=null
    var Adet:Int?=null
    var Fiyat:Double?=null
    var IslemTipi:String?=null

    constructor(Hisse:String,Adet:Int,Fiyat:Double,IslemTipi:String){
        this.Adet=Adet
        this.Fiyat=Fiyat
        this.Hisse=Hisse
        this.IslemTipi=IslemTipi
    }

    constructor()
}