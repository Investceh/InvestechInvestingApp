package com.elifersumer.myapplication.Database

import android.util.Log
import android.widget.Toast
import okhttp3.internal.wait
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class DbManager {
    /*var accountInfo:AccountInfo?=null
    var waitingOrders:ArrayList<WaitingOrder>?=null
    var doneOrders:ArrayList<DonerOrder>?=null
    var canceledOrder:ArrayList<CanceledOrder>?=null*/

    /*fun setDataCO(){
        for (order in canceledOrder!!){
            var hisse = order.Hisse
            var fiyat=order.Fiyat
            var adet = order.Adet
            var islemtipi=order.IslemTipi

            var c=DbConnection()
            var connection: Connection =c.dbConn()!!

            if(c!=null){
                val sqlStatement:String = "INSERT INTO CanceledOrder (Hisse, Adet,Fiyat,IslemTipi) VALUES($hisse,$adet,$fiyat,$islemtipi)"
                val smt : Statement =connection.createStatement()
                smt.executeQuery(sqlStatement)
                connection.close()
            }else{
                var ex=SQLException()
                Log.e("Error",ex.message.toString())
            }

        }
    }

    fun setDataDO(){
        for (order in doneOrders!!){
            var hisse = order.Hisse
            var fiyat=order.Fiyat
            var adet = order.Adet
            var islemtipi=order.IslemTipi

            var c=DbConnection()
            var connection: Connection =c.dbConn()!!

            if(c!=null){
                val sqlStatement:String = "INSERT INTO DoneOrder (Hisse, Adet,Fiyat,IslemTipi) VALUES($hisse,$adet,$fiyat,$islemtipi)"
                val smt : Statement =connection.createStatement()
                smt.executeQuery(sqlStatement)
                connection.close()
            }else{
                var ex=SQLException()
                Log.e("Error",ex.message.toString())
            }

        }
    }*/

    fun setDataWO(waitingOrders:ArrayList<WaitingOrder>){
        val c=DbConnection()
        val connection: Connection =c.dbConn()!!

        fun setDataWO(waitingOrders:ArrayList<WaitingOrder>){

            for (order in waitingOrders!!){
                var hisse = order.Hisse
                var fiyat=order.Fiyat
                var adet = order.Adet
                var islemtipi=order.IslemTipi
                val sql="SELECT * FROM WaitingOrder"
                val rs=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql)
                with(rs){

                    moveToInsertRow()

                    updateString("Hisse", hisse)
                    updateDouble("Fiyat", fiyat!!)
                    updateString("IslemTipi", islemtipi)
                    updateInt("Adet",adet!!)

                    insertRow()
                }

                connection.close()
            }
        }
    }


    /*fun setDataAcc(){
        var vadesiz=accountInfo!!.VadesizBakiye
        var yatirim=accountInfo!!.YatirimBakiye
        var c=DbConnection()
        var connection: Connection =c.dbConn()!!

        if(c!=null){
            val sqlStatement:String = "INSERT INTO AccountInfo (YatirimBakiye, VadesizBakiye) VALUES($vadesiz,$yatirim)"
            val smt : Statement =connection.createStatement()
            smt.executeQuery(sqlStatement)
            connection.close()
        }else{
            var ex=SQLException()
            Log.e("Error",ex.message.toString())
        }
    }*/
}