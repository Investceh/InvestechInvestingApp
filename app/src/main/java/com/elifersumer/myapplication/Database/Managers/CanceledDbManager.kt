package com.elifersumer.myapplication.Database.Managers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import com.elifersumer.myapplication.Database.CanceledOrder
import com.elifersumer.myapplication.Database.Helper.DbHelper

class CanceledDbManager(val context: Context,val dbase: SQLiteDatabase){
    private val TABLE_NAME="CanceledOrder"
    private val COL_ID = "id"
    private val COL_HISSE = "Hisse"
    private val COL_ADET = "Adet"
    private val COL_FIYAT = "Fiyat"
    private val COL_ISLEMTIPI = "Islemtipi"

    fun insertData(canceledOrder: CanceledOrder){
        val sqliteDB = dbase
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE , canceledOrder.Hisse)
        contentValues.put(COL_ADET, canceledOrder.Adet)
        contentValues.put(COL_FIYAT, canceledOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI,canceledOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun readData():MutableList<CanceledOrder>{
        val orderList = mutableListOf<CanceledOrder>()
        val sqliteDB = dbase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val canceledOrder = CanceledOrder()
                canceledOrder.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                canceledOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE))
                canceledOrder.Adet = result.getString(result.getColumnIndex(COL_ADET))
                canceledOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT))
                canceledOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI))
                orderList.add(canceledOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun deleteAllData(){
        val sqliteDB = dbase
        sqliteDB.delete(TABLE_NAME,null,null)
        sqliteDB.close()
    }

    fun deletDataByName(name:String){
        val sqliteDB= dbase
        sqliteDB.delete(TABLE_NAME,COL_HISSE+"="+name,null)
        sqliteDB.close()
    }

}