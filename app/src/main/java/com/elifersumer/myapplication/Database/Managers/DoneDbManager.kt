package com.elifersumer.myapplication.Database.Managers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import com.elifersumer.myapplication.Database.DoneOrder
import com.elifersumer.myapplication.Database.Helper.DbHelper

class DoneDbManager(val context: Context, val dbase: SQLiteDatabase) {
    private val TABLE_NAME="DoneOrder"
    private val COL_ID = "id"
    private val COL_HISSE = "Hisse"
    private val COL_ADET = "Adet"
    private val COL_FIYAT = "Fiyat"
    private val COL_ISLEMTIPI = "Islemtipi"


    fun insertData(doneOrder: DoneOrder){
        val sqliteDB = dbase
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE , doneOrder.Hisse)
        contentValues.put(COL_ADET, doneOrder.Adet)
        contentValues.put(COL_FIYAT, doneOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI,doneOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun readData():MutableList<DoneOrder>{
        val orderList = mutableListOf<DoneOrder>()
        val sqliteDB = dbase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val doneOrder = DoneOrder()
                doneOrder.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                doneOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE))
                doneOrder.Adet = result.getString(result.getColumnIndex(COL_ADET))
                doneOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT))
                doneOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI))
                orderList.add(doneOrder)
            }while (result.moveToNext())
        }
        result.close()
        return orderList
    }

    fun deleteAllData(){
        val sqliteDB = dbase
        sqliteDB.delete(TABLE_NAME,null,null)
        sqliteDB.close()
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