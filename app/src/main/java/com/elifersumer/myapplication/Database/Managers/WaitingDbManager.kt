package com.elifersumer.myapplication.Database.Managers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.WaitingOrder

class WaitingDbManager(val context: Context, val dbase: SQLiteDatabase){
    private val TABLE_NAME="WaitingOrder"
    private val COL_ID = "id"
    private val COL_HISSE = "Hisse"
    private val COL_ADET = "Adet"
    private val COL_FIYAT = "Fiyat"
    private val COL_ISLEMTIPI = "Islemtipi"

    fun delete(){
        val deleteDatabase=""
    }

    fun insertData(waitingOrder: WaitingOrder){
        val sqliteDB = dbase
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE , waitingOrder.Hisse)
        contentValues.put(COL_ADET, waitingOrder.Adet)
        contentValues.put(COL_FIYAT, waitingOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI,waitingOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun readData():MutableList<WaitingOrder>{
        val orderList = mutableListOf<WaitingOrder>()
        val sqliteDB = dbase
        val query = "SELECT * FROM $TABLE_NAME"
        var result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val waitingOrder = WaitingOrder()
                waitingOrder.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                waitingOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE))
                waitingOrder.Adet = result.getString(result.getColumnIndex(COL_ADET))
                waitingOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT))
                waitingOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI))
                orderList.add(waitingOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun deleteAllData(){
        val sqliteDB = dbase
        if(sqliteDB.isOpen==true) {
            sqliteDB.delete(TABLE_NAME, null, null)
            sqliteDB.close()
        }
    }

    fun deletDataByName(name:String){
        val sqliteDB= dbase
        if(sqliteDB.isOpen==true) {
            val query="DELETE FROM " + TABLE_NAME+ " WHERE "+COL_HISSE+"='"+name+"'"
            sqliteDB.execSQL(query)
            sqliteDB.close()
        }
    }

}