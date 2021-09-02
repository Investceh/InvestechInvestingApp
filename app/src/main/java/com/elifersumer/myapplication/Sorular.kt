package com.elifersumer.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_sorular.*

class Sorular : AppCompatActivity() {

    lateinit var radio_group1: RadioGroup

    lateinit var soru1_sık1: RadioButton
    lateinit var soru1_sık2: RadioButton
    lateinit var soru1_sık3: RadioButton
    lateinit var soru1_sık4: RadioButton
    lateinit var soru1_sık5: RadioButton


    lateinit var radio_group2: RadioGroup

    lateinit var soru2_sık1: RadioButton
    lateinit var soru2_sık2: RadioButton
    lateinit var soru2_sık3: RadioButton
    lateinit var soru2_sık4: RadioButton
    lateinit var soru2_sık5: RadioButton


    lateinit var radio_group3: RadioGroup

    lateinit var soru3_sık1: RadioButton
    lateinit var soru3_sık2: RadioButton
    lateinit var soru3_sık3: RadioButton
    lateinit var soru3_sık4: RadioButton
    lateinit var soru3_sık5: RadioButton


    lateinit var radio_group4: RadioGroup

    lateinit var soru4_sık1: RadioButton
    lateinit var soru4_sık2: RadioButton
    lateinit var soru4_sık3: RadioButton
    lateinit var soru4_sık4: RadioButton
    lateinit var soru4_sık5: RadioButton


    lateinit var radio_group5: RadioGroup

    lateinit var soru5_sık1: RadioButton
    lateinit var soru5_sık2: RadioButton
    lateinit var soru5_sık3: RadioButton
    lateinit var soru5_sık4: RadioButton
    lateinit var soru5_sık5: RadioButton

    lateinit var btn_bitir: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorular)

        radio_group1 = findViewById(R.id.radio_group1) as RadioGroup

        soru1_sık1 = findViewById(R.id.soru1_sık1) as RadioButton
        soru1_sık2 = findViewById(R.id.soru1_sık2) as RadioButton
        soru1_sık3 = findViewById(R.id.soru1_sık3) as RadioButton
        soru1_sık4 = findViewById(R.id.soru1_sık4) as RadioButton
        soru1_sık5 = findViewById(R.id.soru1_sık5) as RadioButton


        radio_group2 = findViewById(R.id.radio_group2) as RadioGroup

        soru2_sık1 = findViewById(R.id.soru2_sık1) as RadioButton
        soru2_sık2 = findViewById(R.id.soru2_sık2) as RadioButton
        soru2_sık3 = findViewById(R.id.soru2_sık3) as RadioButton
        soru2_sık4 = findViewById(R.id.soru2_sık4) as RadioButton
        soru2_sık5 = findViewById(R.id.soru2_sık5) as RadioButton


        radio_group3 = findViewById(R.id.radio_group3) as RadioGroup

        soru3_sık1 = findViewById(R.id.soru3_sık1) as RadioButton
        soru3_sık2 = findViewById(R.id.soru3_sık2) as RadioButton
        soru3_sık3 = findViewById(R.id.soru3_sık3) as RadioButton
        soru3_sık4 = findViewById(R.id.soru3_sık4) as RadioButton
        soru3_sık5 = findViewById(R.id.soru3_sık5) as RadioButton


        radio_group4 = findViewById(R.id.radio_group4) as RadioGroup

        soru4_sık1 = findViewById(R.id.soru4_sık1) as RadioButton
        soru4_sık2 = findViewById(R.id.soru4_sık2) as RadioButton
        soru4_sık3 = findViewById(R.id.soru4_sık3) as RadioButton
        soru4_sık4 = findViewById(R.id.soru4_sık4) as RadioButton
        soru4_sık5 = findViewById(R.id.soru4_sık5) as RadioButton



        radio_group5 = findViewById(R.id.radio_group5) as RadioGroup

        soru5_sık1 = findViewById(R.id.soru5_sık1) as RadioButton
        soru5_sık2 = findViewById(R.id.soru5_sık2) as RadioButton
        soru5_sık3 = findViewById(R.id.soru5_sık3) as RadioButton
        soru5_sık4 = findViewById(R.id.soru5_sık4) as RadioButton
        soru5_sık5 = findViewById(R.id.soru5_sık5) as RadioButton

        btn_bitir = findViewById(R.id.btn_bitir) as Button



        radio_group1.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.soru1_sık1 -> {
                    soru1_sık1.setBackgroundColor(Color.parseColor("#87C471"))
                    soru1_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru1_sık2 -> {
                    soru1_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık2.setBackgroundColor(Color.parseColor("#87C471"))
                    soru1_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru1_sık3 -> {
                    soru1_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık3.setBackgroundColor(Color.parseColor("#87C471"))
                    soru1_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru1_sık4 -> {
                    soru1_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık4.setBackgroundColor(Color.parseColor("#87C471"))
                    soru1_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru1_sık5 -> {
                    soru1_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru1_sık5.setBackgroundColor(Color.parseColor("#87C471"))
                }
            }

            var secilen_button1 = radio_group1.checkedRadioButtonId
            var secilen1_string = resources.getResourceEntryName(secilen_button1)
            Toast.makeText(this,secilen1_string,Toast.LENGTH_SHORT).show()
        })



        radio_group2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.soru2_sık1 -> {
                    soru2_sık1.setBackgroundColor(Color.parseColor("#87C471"))
                    soru2_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru2_sık2 -> {
                    soru2_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık2.setBackgroundColor(Color.parseColor("#87C471"))
                    soru2_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru2_sık3 -> {
                    soru2_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık3.setBackgroundColor(Color.parseColor("#87C471"))
                    soru2_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru2_sık4 -> {
                    soru2_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık4.setBackgroundColor(Color.parseColor("#87C471"))
                    soru2_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru2_sık5 -> {
                    soru2_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru2_sık5.setBackgroundColor(Color.parseColor("#87C471"))
                }
            }
            var secilen_button1 = radio_group2.checkedRadioButtonId
            var secilen1_string = resources.getResourceEntryName(secilen_button1)
            Toast.makeText(this,secilen1_string,Toast.LENGTH_SHORT).show()
        })


        radio_group3.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.soru3_sık1 -> {
                    soru3_sık1.setBackgroundColor(Color.parseColor("#87C471"))
                    soru3_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru3_sık2 -> {
                    soru3_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık2.setBackgroundColor(Color.parseColor("#87C471"))
                    soru3_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru3_sık3 -> {
                    soru3_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık3.setBackgroundColor(Color.parseColor("#87C471"))
                    soru3_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru3_sık4 -> {
                    soru3_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık4.setBackgroundColor(Color.parseColor("#87C471"))
                    soru3_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru3_sık5 -> {
                    soru3_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru3_sık5.setBackgroundColor(Color.parseColor("#87C471"))
                }
            }
            var secilen_button1 = radio_group3.checkedRadioButtonId
            var secilen1_string = resources.getResourceEntryName(secilen_button1)
            Toast.makeText(this,secilen1_string,Toast.LENGTH_SHORT).show()
        })


        radio_group4.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.soru4_sık1 -> {
                    soru4_sık1.setBackgroundColor(Color.parseColor("#87C471"))
                    soru4_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru4_sık2 -> {
                    soru4_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık2.setBackgroundColor(Color.parseColor("#87C471"))
                    soru4_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru4_sık3 -> {
                    soru4_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık3.setBackgroundColor(Color.parseColor("#87C471"))
                    soru4_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru4_sık4 -> {
                    soru4_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık4.setBackgroundColor(Color.parseColor("#87C471"))
                    soru4_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru4_sık5 -> {
                    soru4_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru4_sık5.setBackgroundColor(Color.parseColor("#87C471"))
                }
            }
            var secilen_button1 = radio_group4.checkedRadioButtonId
            var secilen1_string = resources.getResourceEntryName(secilen_button1)
            Toast.makeText(this,secilen1_string,Toast.LENGTH_SHORT).show()
        })



        radio_group5.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.soru5_sık1 -> {
                    soru5_sık1.setBackgroundColor(Color.parseColor("#87C471"))
                    soru5_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru5_sık2 -> {
                    soru5_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık2.setBackgroundColor(Color.parseColor("#87C471"))
                    soru5_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru5_sık3 -> {
                    soru5_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık3.setBackgroundColor(Color.parseColor("#87C471"))
                    soru5_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru5_sık4 -> {
                    soru5_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık4.setBackgroundColor(Color.parseColor("#87C471"))
                    soru5_sık5.setBackgroundColor(Color.parseColor("#6A8AB0"))
                }
                R.id.soru5_sık5 -> {
                    soru5_sık1.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık2.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık3.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık4.setBackgroundColor(Color.parseColor("#6A8AB0"))
                    soru5_sık5.setBackgroundColor(Color.parseColor("#87C471"))
                }
            }
            var secilen_button1 = radio_group5.checkedRadioButtonId
            var secilen1_string = resources.getResourceEntryName(secilen_button1)
            Toast.makeText(this,secilen1_string,Toast.LENGTH_SHORT).show()
        })

        btn_bitir.setOnClickListener(View.OnClickListener {
            var secilen_button1 = radio_group1.checkedRadioButtonId
            var secilen1_string = resources.getResourceEntryName(secilen_button1)


            var secilen_button2 = radio_group2.checkedRadioButtonId
            var secilen2_string = resources.getResourceEntryName(secilen_button2)


            var secilen_button3 = radio_group3.checkedRadioButtonId
            var secilen3_string = resources.getResourceEntryName(secilen_button3)


            var secilen_button4 = radio_group4.checkedRadioButtonId
            var secilen4_string = resources.getResourceEntryName(secilen_button4)


            var secilen_button5 = radio_group5.checkedRadioButtonId
            var secilen5_string = resources.getResourceEntryName(secilen_button5)

            //format --> soru#_sık#
            //
        })
    }
}