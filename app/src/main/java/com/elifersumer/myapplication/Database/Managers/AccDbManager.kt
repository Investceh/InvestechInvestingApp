package com.elifersumer.myapplication.Database.Managers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import com.elifersumer.myapplication.Database.AccountInfo
import com.elifersumer.myapplication.Database.CanceledOrder
import com.elifersumer.myapplication.Database.Helper.DbHelper

class AccDbManager(val context: Context, val dbase:SQLiteDatabase) {
    private val TABLE_NAME="AccountInfo"
    private val COL_ID = "id"
    private val COL_YATIRIM = "YatirimBakiye"
    private val COL_VADESIZ = "VadesizBakiye"

    fun insertData(accountInfo: AccountInfo){
        val sqliteDB = dbase
        val contentValues = ContentValues()
        contentValues.put(COL_VADESIZ , accountInfo.VadesizBakiye)
        contentValues.put(COL_YATIRIM, accountInfo.YatirimBakiye)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)
    }

    fun readData():MutableList<AccountInfo>{
        val accList = mutableListOf<AccountInfo>()
        val sqliteDB = dbase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val accountInfo = AccountInfo()
                accountInfo.VadesizBakiye = result.getDouble(result.getColumnIndex(COL_VADESIZ))
                accountInfo.YatirimBakiye = result.getDouble(result.getColumnIndex(COL_YATIRIM))
                accList.add(accountInfo)
            }while (result.moveToNext())
        }
        result.close()
        return accList
    }

    fun updateBalance(yatirim:Double,vadesiz:Double) {
        val db = dbase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            val cv = ContentValues()
            cv.put(COL_YATIRIM,(yatirim))
            cv.put(COL_VADESIZ,(vadesiz))
            db.update(TABLE_NAME,cv, null, null)
        }
        result.close()
    }
}