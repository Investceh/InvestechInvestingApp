package com.elifersumer.myapplication.Database.Helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AccDbHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    private val TABLE_NAME="AccountInfo"
    private val COL_ID = "id"
    private val COL_YATIRIM = "yatirim"
    private val COL_VADESIZ = "bakiye"

    companion object {
        private val DATABASE_NAME = "INVESTECH"//database adı
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_YATIRIM  FLOAT,$COL_VADESIZ  FLOAT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun updateBalance(yatirim:Double,vadesiz:Double) {
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            val cv = ContentValues()
            cv.put(COL_YATIRIM,(result.getInt(result.getColumnIndex(COL_YATIRIM))+yatirim))
            cv.put(COL_VADESIZ,(result.getInt(result.getColumnIndex(COL_VADESIZ))+vadesiz))
            db.update(TABLE_NAME,cv, null, null)
        }

        result.close()
        db.close()
    }
}