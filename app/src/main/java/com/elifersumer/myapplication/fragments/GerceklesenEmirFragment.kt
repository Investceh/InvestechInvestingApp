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
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import kotlinx.android.synthetic.main.fragment_bekleyen_emir.*
import kotlinx.android.synthetic.main.fragment_emirgiris.*
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.*
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*


class GerceklesenEmirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gerceklesen_emir, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var geEmirler = mutableListOf(
            GeEmirlerimData("AGHOL","15","24.12","Alış"),
            GeEmirlerimData("ALKIM","20","15.04","Satış")
        )
        ge_emir_recyclerView.layoutManager= LinearLayoutManager(context)
        ge_emir_recyclerView.adapter= RecyclerViewAdapterGeEmirlerim(geEmirler)
    }
}