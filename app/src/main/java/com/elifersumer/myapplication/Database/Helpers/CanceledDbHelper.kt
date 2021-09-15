package com.elifersumer.myapplication.Database.Helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.elifersumer.myapplication.Database.CanceledOrder

class CanceledDbHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    private val TABLE_NAME="CanceledOrder"
    private val COL_ID = "id"
    private val COL_HISSE = "hisse"
    private val COL_ADET = "adet"
    private val COL_FIYAT = "fiyat"
    private val COL_ISLEMTIPI = "islemtipi"
    companion object {
        private val DATABASE_NAME = "INVESTECH"//database adı
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_HISSE  VARCHAR(256),$COL_ADET  INTEGER,$COL_FIYAT  FLOAT,$COL_ISLEMTIPI VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertData(canceledOrder: CanceledOrder){
        val sqliteDB = this.writableDatabase
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
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val canceledOrder = CanceledOrder()
                canceledOrder.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                canceledOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE))
                canceledOrder.Adet = result.getString(result.getColumnIndex(COL_ADET)).toInt()
                canceledOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT)).toDouble()
                canceledOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI))
                orderList.add(canceledOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun deleteAllData(){
        val sqliteDB = this.writableDatabase
        sqliteDB.delete(TABLE_NAME,null,null)
        sqliteDB.close()
    }

    fun deletDataByName(name:String){
        val sqliteDB=this.writableDatabase
        sqliteDB.delete(TABLE_NAME,COL_HISSE+"="+name,null)
        sqliteDB.close()
    }

}