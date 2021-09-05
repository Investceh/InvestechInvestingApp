package com.elifersumer.myapplication.data

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DbConnection {


    private val db = "Investech"
    private val url = "jdbc:jtds:sqlserver://./Investech;instance=<pipe name>;namedPipe=true"

    fun Conn():Connection?{
        val policy=StrictMode.ThreadPolicy.Builder().permitAll().build()
        var con : Connection?=null
        try{
            Class.forName("net.sourceforge.jtds.jdbc.driver")
            con=DriverManager.getConnection(url)
        }catch(ex:SQLException){
            Log.e("error",ex.message.toString())
        }catch (ex1:ClassNotFoundException){
            Log.e("error",ex1.message.toString())
        }catch (ex2: Exception){
            Log.e("error",ex2.message.toString())
        }

        return con
    }
}