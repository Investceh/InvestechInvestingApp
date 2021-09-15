package com.elifersumer.myapplication.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(val context: Context) : SQLiteOpenHelper(context,DBHelper.DATABASE_NAME,null,DBHelper.DATABASE_VERSION) {
    private val TABLE_NAME="WaitingOrder"
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

    fun insertData(waitingOrder: WaitingOrder){
        val sqliteDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE , waitingOrder.Hisse)
        contentValues.put(COL_ADET, waitingOrder.Adet)
        contentValues.put(COL_FIYAT, waitingOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI,waitingOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Başarılı" else "Emir yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun readData():MutableList<WaitingOrder>{
        val orderList = mutableListOf<WaitingOrder>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val waitingOrder = WaitingOrder()
                waitingOrder.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                waitingOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE))
                waitingOrder.Adet = result.getString(result.getColumnIndex(COL_ADET)).toInt()
                waitingOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT)).toDouble()
                waitingOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI))
                orderList.add(waitingOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun readDataByHisse(hisse:String):MutableList<WaitingOrder>{
        val userList = mutableListOf<WaitingOrder>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE hisse=$hisse"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val waitingOrder = WaitingOrder()
                waitingOrder.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                waitingOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE))
                waitingOrder.Adet = result.getString(result.getColumnIndex(COL_ADET)).toInt()
                waitingOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT)).toDouble()
                waitingOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI))
                userList.add(waitingOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return userList
    }
    fun deleteAllData(){
        val sqliteDB = this.writableDatabase
        sqliteDB.delete(TABLE_NAME,null,null)
        sqliteDB.close()

    }

}