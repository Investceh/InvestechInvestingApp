package com.elifersumer.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_para_transferi.*

class ParaTransferi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_para_transferi)
        /*
        val options = arrayOf("Vadesizden Yatırıma", "Yatırımdan Vadesize")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, options)

        sp_option.adapter = arrayAdapter

        sp_option.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }*/
    }

}