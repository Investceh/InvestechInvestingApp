package com.elifersumer.myapplication.Database.Helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME ,null, DATABASE_VERSION) {

    private val TABLE_NAME1="WaitingOrder"
    private val COL_ID1 = "id"
    private val COL_HISSE1 = "hisse"
    private val COL_ADET1 = "adet"
    private val COL_FIYAT1 = "fiyat"
    private val COL_ISLEMTIPI1 = "islemtipi"

    private val TABLE_NAME2="DoneOrder"
    private val COL_ID2 = "id"
    private val COL_HISSE2 = "hisse"
    private val COL_ADET2 = "adet"
    private val COL_FIYAT2 = "fiyat"
    private val COL_ISLEMTIPI2 = "islemtipi"

    private val TABLE_NAME3="CanceledOrder"
    private val COL_ID3 = "id"
    private val COL_HISSE3 = "hisse"
    private val COL_ADET3 = "adet"
    private val COL_FIYAT3 = "fiyat"
    private val COL_ISLEMTIPI3 = "islemtipi"

    private val TABLE_NAME4="AccountInfo"
    private val COL_ID4 = "id"
    private val COL_YATIRIM = "yatirim"
    private val COL_VADESIZ = "bakiye"


    companion object {
        private val DATABASE_NAME = "INVESTECH"//database adı
        private val DATABASE_VERSION = 1

    }

    override fun onCreate(db: SQLiteDatabase?) {
       /* val createTable1 = "CREATE TABLE $TABLE_NAME1 ($COL_ID1 INTEGER PRIMARY KEY AUTOINCREMENT, Hisse  VARCHAR(256),Adet  INTEGER,Fiyat  FLOAT,Islemtipi VARCHAR(256))"
        val createTable2 = "CREATE TABLE $TABLE_NAME2 ($COL_ID2 INTEGER PRIMARY KEY AUTOINCREMENT, Hisse  VARCHAR(256),Adet  VARCHAR(256),Fiyat  VARCHAR(256),Islemtipi VARCHAR(256))"
        val createTable3 = "CREATE TABLE $TABLE_NAME3 ($COL_ID3 INTEGER PRIMARY KEY AUTOINCREMENT, Hisse  VARCHAR(256),Adet  INTEGER,Fiyat  FLOAT,Islemtipi VARCHAR(256))"
        val createTable4 = "CREATE TABLE $TABLE_NAME4 ($COL_ID4 INTEGER PRIMARY KEY AUTOINCREMENT, VadesizBakiye FLOAT,YatirimBakiye  FLOAT)"

        db?.execSQL(createTable1)
        db?.execSQL(createTable2)
        db?.execSQL(createTable3)
        db?.execSQL(createTable4)*/
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
/*
    //WaitingOrder
    fun wInsertData(waitingOrder: WaitingOrder){
        val sqliteDB =
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE1 , waitingOrder.Hisse)
        contentValues.put(COL_ADET1, waitingOrder.Adet)
        contentValues.put(COL_FIYAT1, waitingOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI1,waitingOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME1,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun wReadData():MutableList<WaitingOrder>{
        val orderList = mutableListOf<WaitingOrder>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME1"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val waitingOrder = WaitingOrder()
                waitingOrder.Id = result.getString(result.getColumnIndex(COL_ID1)).toInt()
                waitingOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE1))
                waitingOrder.Adet = result.getString(result.getColumnIndex(COL_ADET1)).toInt()
                waitingOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT1)).toDouble()
                waitingOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI1))
                orderList.add(waitingOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun wDeleteAllData(){
        val sqliteDB = this.writableDatabase
        sqliteDB.delete(TABLE_NAME1,null,null)
        sqliteDB.close()
    }

    fun wDeletDataByName(name:String){
        val sqliteDB=this.writableDatabase
        sqliteDB.delete(TABLE_NAME1,COL_HISSE1+"="+name,null)
        sqliteDB.close()
    }

    //DoneOrder

    fun dInsertData(doneOrder: DoneOrder){
        val sqliteDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE2 , doneOrder.Hisse)
        contentValues.put(COL_ADET2, doneOrder.Adet)
        contentValues.put(COL_FIYAT2, doneOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI2,doneOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME2,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun dReadData():MutableList<DoneOrder>{
        val orderList = mutableListOf<DoneOrder>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME2"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val doneOrder = DoneOrder()
                doneOrder.Id = result.getString(result.getColumnIndex(COL_ID2)).toInt()
                doneOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE2))
                doneOrder.Adet = result.getString(result.getColumnIndex(COL_ADET2)).toInt()
                doneOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT2)).toDouble()
                doneOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI2))
                orderList.add(doneOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun dDeleteAllData(){
        val sqliteDB = this.writableDatabase
        sqliteDB.delete(TABLE_NAME2,null,null)
        sqliteDB.close()
    }

    fun dDeletDataByName(name:String){
        val sqliteDB=this.writableDatabase
        sqliteDB.delete(TABLE_NAME2,COL_HISSE2+"="+name,null)
        sqliteDB.close()
    }

    //CanceledOrder

    fun cInsertData(canceledOrder: CanceledOrder){
        val sqliteDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_HISSE3 , canceledOrder.Hisse)
        contentValues.put(COL_ADET3, canceledOrder.Adet)
        contentValues.put(COL_FIYAT3, canceledOrder.Fiyat)
        contentValues.put(COL_ISLEMTIPI3,canceledOrder.IslemTipi)

        val result = sqliteDB.insert(TABLE_NAME3,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun cReadData():MutableList<CanceledOrder>{
        val orderList = mutableListOf<CanceledOrder>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME3"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val canceledOrder = CanceledOrder()
                canceledOrder.Id = result.getString(result.getColumnIndex(COL_ID3)).toInt()
                canceledOrder.Hisse = result.getString(result.getColumnIndex(COL_HISSE3))
                canceledOrder.Adet = result.getString(result.getColumnIndex(COL_ADET3)).toInt()
                canceledOrder.Fiyat = result.getString(result.getColumnIndex(COL_FIYAT3)).toDouble()
                canceledOrder.IslemTipi=result.getString(result.getColumnIndex(COL_ISLEMTIPI3))
                orderList.add(canceledOrder)
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return orderList
    }

    fun cDeleteAllData(){
        val sqliteDB = this.writableDatabase
        sqliteDB.delete(TABLE_NAME3,null,null)
        sqliteDB.close()
    }

    fun cDeletDataByName(name:String){
        val sqliteDB=this.writableDatabase
        sqliteDB.delete(TABLE_NAME3,COL_HISSE3+"="+name,null)
        sqliteDB.close()
    }

    //AccountInfo
    fun updateBalance(yatirim:Double,vadesiz:Double) {
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME4"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            val cv = ContentValues()
            cv.put(COL_YATIRIM,(result.getInt(result.getColumnIndex(COL_YATIRIM))+yatirim))
            cv.put(COL_VADESIZ,(result.getInt(result.getColumnIndex(COL_VADESIZ))+vadesiz))
            db.update(TABLE_NAME4,cv, null, null)
        }

        result.close()
        db.close()
    }*/
}