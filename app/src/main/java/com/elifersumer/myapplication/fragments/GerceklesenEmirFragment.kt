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
import androidx.core.view.marginLeft
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_emirgiris.*
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*


class GerceklesenEmirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_green, null)
        val drawable2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_red, null)
        val drawable_al: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.alll, null)
        val drawable3: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg3, null)
        val drawable_al2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.al_2, null)
        val drawable_sat2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.sat_2, null)

        val drawable4: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg1, null)
       // val drawable5: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_gradient, null)
        val view = inflater.inflate(R.layout.fragment_gerceklesen_emir, container, false)
        val tabLay = view.table_layout_g
        var alisOrSatis = "Alis"

        for (i in 0..20){
            if( i % 2  == 0 )
                alisOrSatis = "Alış"
            else
                alisOrSatis = "Satış"

            val tbr2 = TableRow(this.context)

            val txt5 = TextView(this.context)
            txt5.setText("AGYO")
            txt5.setTextColor(Color.BLACK)
            txt5.gravity = Gravity.CENTER_VERTICAL
            txt5.setTextSize(15F)
            tbr2.addView(txt5)

            val txt6 = TextView(this.context)
            txt6.setText("\t\t\t" + "18")
            txt6.setTextColor(Color.BLACK)
            txt6.gravity = Gravity.CENTER_VERTICAL
            txt6.setTextSize(15F)
            tbr2.addView(txt6)

            val txt7 = TextView(this.context)
            txt7.setText("\t\t\t\t\t" + "124.10")
            txt7.setTextColor(Color.BLACK)
            txt7.gravity =Gravity.CENTER_VERTICAL
            txt7.setTextSize(15F)
            tbr2.addView(txt7)



            val txt8 = TextView(this.context)
            txt8.setText("\t\t\t" + alisOrSatis)
            txt8.setTextColor(Color.BLACK)
            txt8.gravity = Gravity.CENTER_VERTICAL
            txt8.setTextSize(15F)
            tbr2.addView(txt8)

            if(alisOrSatis == "Alış")
                tbr2.setBackground(drawable_al2)
            else
                tbr2.setBackground(drawable_sat2)
            tbr2.setPadding(25,15,25,15)
            tabLay.addView(tbr2)
        }


        return view
    }

}