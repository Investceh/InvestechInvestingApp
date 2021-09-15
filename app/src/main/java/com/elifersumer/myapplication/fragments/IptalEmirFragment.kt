package com.elifersumer.myapplication.fragments

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.CanceledDbManager
import com.elifersumer.myapplication.Database.Managers.DoneDbManager
import com.elifersumer.myapplication.GeEmirlerimData
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapterGeEmirlerim
import com.elifersumer.myapplication.RecyclerViewAdapterIpEmirlerim
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.*
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*
import kotlinx.android.synthetic.main.fragment_iptal_emir.*


class IptalEmirFragment : Fragment() {
    val db by lazy { DbHelper(this@IptalEmirFragment.requireActivity()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_iptal_emir, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var canceledDbManager = CanceledDbManager(this@IptalEmirFragment.requireActivity(),db.readableDatabase)
        var ipEmirler = canceledDbManager.readData()
        ip_emir_recyclerView.layoutManager= LinearLayoutManager(context)
        ip_emir_recyclerView.adapter= RecyclerViewAdapterIpEmirlerim(ipEmirler)
    }
}