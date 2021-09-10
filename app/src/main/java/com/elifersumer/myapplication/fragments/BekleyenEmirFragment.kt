package com.elifersumer.myapplication.fragments

import android.R.attr
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*
import android.R.attr.button
import android.app.ActionBar
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.BekleyenEmirlerimData
import com.elifersumer.myapplication.RecyclerViewAdapterBekEmirlerim
import com.elifersumer.myapplication.RecyclerViewAdapterPiyasa
import kotlinx.android.synthetic.main.fragment_bekleyen_emir.*
import kotlinx.android.synthetic.main.fragment_piyasa.*
import kotlinx.coroutines.delay


class BekleyenEmirFragment : Fragment() {

    lateinit var tumu_sil: Button
    lateinit var bekleyenEmirler: MutableList<BekleyenEmirlerimData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bekleyen_emir, container, false)
        tumu_sil = view.findViewById(R.id.bekleyen_emir) as Button

        bekleyenEmirler = mutableListOf(
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("ALKIM","20","15.04","Satış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş"),
        )
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tumu_sil.setOnClickListener(View.OnClickListener {

            bekleyenEmirler.clear()

            bkl_emir_recyclerView.layoutManager= LinearLayoutManager(context)
            bkl_emir_recyclerView.adapter= RecyclerViewAdapterBekEmirlerim(bekleyenEmirler)
        })


        bkl_emir_recyclerView.layoutManager= LinearLayoutManager(context)
        bkl_emir_recyclerView.adapter= RecyclerViewAdapterBekEmirlerim(bekleyenEmirler)

    }
}