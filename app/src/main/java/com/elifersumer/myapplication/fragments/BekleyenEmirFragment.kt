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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bekleyen_emir, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bekleyenEmirler = arrayListOf(
            BekleyenEmirlerimData("AGHOL","15","24.12","Alış","İptal","Değiş")
        )
        bkl_emir_recyclerView.layoutManager= LinearLayoutManager(context)
        bkl_emir_recyclerView.adapter= RecyclerViewAdapterBekEmirlerim(bekleyenEmirler)
    }


}