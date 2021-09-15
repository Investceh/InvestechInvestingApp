package com.elifersumer.myapplication.Database.Managers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.elifersumer.myapplication.Database.Helper.DbHelper

class AccDbManager(val context: Context, val dbase:SQLiteDatabase) {
    private val TABLE_NAME="AccountInfo"
    private val COL_ID = "id"
    private val COL_YATIRIM = "yatirim"
    private val COL_VADESIZ = "bakiye"


    fun updateBalance(yatirim:Double,vadesiz:Double) {
        val db = dbase
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