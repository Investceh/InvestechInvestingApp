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
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.PiyasaData
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapter
import com.elifersumer.myapplication.RecyclerViewAdapterPiyasa
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*
import kotlinx.android.synthetic.main.fragment_karsilama.*
import kotlinx.android.synthetic.main.fragment_piyasa.*

class PiyasaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_piyasa, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val drawable1: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_green, null)
        val textView = TextView(this.context)
        textView.setBackground(drawable1)
        super.onViewCreated(view, savedInstanceState)
        val all_hisse = arrayListOf(
            PiyasaData(
                "deg","ALKIM","15.04","15.03",
                                            "1.48","Sat","Al"),
            PiyasaData("deg","AKCNS","15.03","15.29",
                "-0.20","Sat","Al")
        )
        piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
        piyasa_recyclerView.adapter= RecyclerViewAdapterPiyasa(all_hisse)

    }
}