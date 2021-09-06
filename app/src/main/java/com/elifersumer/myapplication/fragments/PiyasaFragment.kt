package com.elifersumer.myapplication.fragments

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*

class PiyasaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_green, null)
        val drawable2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_red, null)
        val drawable3: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg3, null)
        val drawable4: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg1, null)
        val drawable5: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button, null)
        val drawable6: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_green, null)
        val drawable7: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_red, null)
        val view = inflater.inflate(R.layout.fragment_piyasa, container, false)
        val tabLay = view.table_layout_g
        var alisOrSatis = "Alis"

        for (i in 0..5){


            val tbr2 = TableRow(this.context)

            val txt5 = TextView(this.context)
            txt5.setBackground(drawable6)
            txt5.setTextSize(2F)
            txt5.width = 3
            tbr2.addView(txt5)

            val txt6 = TextView(this.context)
            txt6.setText("AGHOL")
            txt6.setTextColor(Color.BLACK)
            txt6.gravity = Gravity.CENTER_VERTICAL
            txt6.setTextSize(12F)
            tbr2.addView(txt6)

            val txt7 = TextView(this.context)
            txt7.setText("24.12")
            txt7.setTextColor(Color.BLACK)
            txt7.gravity = Gravity.CENTER_VERTICAL
            txt7.setTextSize(12F)
            tbr2.addView(txt7)



            val txt8 = TextView(this.context)
            txt8.setText("24.1")
            txt8.setTextColor(Color.BLACK)
            txt8.gravity = Gravity.CENTER_VERTICAL
            txt8.setTextSize(12F)
            tbr2.addView(txt8)

            val txt9 = TextView(this.context)
            txt9.setText("0.67")
            txt9.setTextColor(Color.BLACK)
            txt9.gravity = Gravity.CENTER_VERTICAL
            txt9.setTextSize(12F)
            tbr2.addView(txt9)


            val btn1 = Button(this.context)
            btn1.setText("Sat")
            btn1.setTextColor(Color.WHITE)
            btn1.gravity = Gravity.CENTER_VERTICAL
            btn1.setBackgroundColor(Color.RED)
            tbr2.addView(btn1)

            val btn2 = Button(this.context)
            btn2.setText("Al")
            btn2.setTextColor(Color.WHITE)
            btn2.gravity = Gravity.CENTER_VERTICAL
            btn2.setBackgroundColor(Color.RED)
            tbr2.addView(btn2)


            if( i % 2  == 0 )
                tbr2.setBackgroundColor(Color.BLUE)
            else
                tbr2.setBackgroundColor(Color.WHITE)
            tbr2.setPadding(25,15,25,15)

            tabLay.addView(tbr2)
        }


        return view
    }
}