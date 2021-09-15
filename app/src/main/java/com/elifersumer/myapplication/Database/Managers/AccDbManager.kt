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
    private val COL_YATIRIM = "Yatirim"
    private val COL_VADESIZ = "Bakiye"

    fun insertData(accountInfo: AccountInfo){
        val sqliteDB = dbase
        val contentValues = ContentValues()
        contentValues.put(COL_VADESIZ , accountInfo.VadesizBakiye)
        contentValues.put(COL_YATIRIM, accountInfo.YatirimBakiye)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Emir Girişi Başarılı" else "Emir girişi yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun readVadesiz():Double{
        val sqliteDB = dbase
        val query = "SELECT Yatirim FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)

        val accountInfo = AccountInfo()
        accountInfo.VadesizBakiye = result.getDouble(result.getColumnIndex(COL_VADESIZ))
        var bakiye_vadesiz:Double=accountInfo.VadesizBakiye!!

        result.close()
        sqliteDB.close()
        return bakiye_vadesiz
    }

    fun readYatirim():Double{
        val sqliteDB = dbase
        val query = "SELECT Bakiye FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)

        val accountInfo = AccountInfo()
        accountInfo.YatirimBakiye = result.getDouble(result.getColumnIndex(COL_YATIRIM))
        var bakiye_yatirim:Double=accountInfo.YatirimBakiye!!

        result.close()
        sqliteDB.close()
        return bakiye_yatirim
    }

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