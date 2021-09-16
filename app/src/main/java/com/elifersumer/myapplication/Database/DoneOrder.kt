package com.elifersumer.myapplication.Database

class DoneOrder {
    var Id:Int?=null
    var Hisse:String?=null
    var Adet:String?=null
    var Fiyat:String?=null
    var IslemTipi:String?=null

    constructor(Hisse:String,Adet:String,Fiyat:String,IslemTipi:String){
        this.Adet=Adet
        this.Fiyat=Fiyat
        this.Hisse=Hisse
        this.IslemTipi=IslemTipi
    }

    constructor()
}