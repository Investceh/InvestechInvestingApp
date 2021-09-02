package com.elifersumer.myapplication

data class Event(var type: String = "", var date: String = "",var quantity: Double? = 0.0, var units : String, var description: String){
    override fun toString(): String {
        return "$type $quantity $units $description"
    }
}
