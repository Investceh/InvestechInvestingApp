package com.elifersumer.myapplication.Database

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DbConnection {
    private val ip = "169.254.241.88:1433"
    private val db = "investech"

    fun dbConn(): Connection?{
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn:Connection?=null
        var connString:String?=null
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            connString="jdbc:jtds:sqlserver://$ip;databaseName=$db;"
            conn= DriverManager.getConnection(connString)
        }catch(ex: SQLException){
            Log.e("Error",ex.message!!)
        }

        return conn
    }
}