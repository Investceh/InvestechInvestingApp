package com.elifersumer.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class karsilama : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_accounts)
            val listView = findViewById<ListView>(R.id.listView)
            val col = Color.parseColor("#000000")
            listView.setBackgroundColor(col)
            listView.adapter = customAdaptor(this)

        }

    private class customAdaptor(context: Context): BaseAdapter() {
        private val mContext : Context

        init{
            this.mContext = context
        }
        override fun getCount(): Int {
            TODO("Not yet implemented")
            return 5
        }

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
            return "Test String"
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            TODO("Not yet implemented")
            val text = TextView(mContext)
            text.text = "Here is there"
            return text
        }
    }
}
