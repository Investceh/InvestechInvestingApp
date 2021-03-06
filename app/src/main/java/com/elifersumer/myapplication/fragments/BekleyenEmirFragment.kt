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
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*
import android.R.attr.button
import android.app.ActionBar
import android.util.Log
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import com.elifersumer.myapplication.Database.CanceledOrder
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.CanceledDbManager
import com.elifersumer.myapplication.Database.Managers.WaitingDbManager
import com.elifersumer.myapplication.Database.WaitingOrder
import kotlinx.android.synthetic.main.fragment_bekleyen_emir.*
import kotlinx.android.synthetic.main.fragment_piyasa.*
import kotlinx.coroutines.delay


class BekleyenEmirFragment : Fragment() {
    val db by lazy { DbHelper(this@BekleyenEmirFragment.requireActivity()) }
    var navController: NavController? = null
    lateinit var tumu_sil: Button
    lateinit var bekleyenEmirler: MutableList<WaitingOrder>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bekleyen_emir, container, false)
        tumu_sil = view.findViewById(R.id.bekleyen_emir) as Button


        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var waitingDbManager = WaitingDbManager(this@BekleyenEmirFragment.requireActivity(),db.writableDatabase)
        var canceledDbManager= CanceledDbManager(this@BekleyenEmirFragment.requireActivity(),db.writableDatabase)
        bekleyenEmirler = waitingDbManager.readData()
        tumu_sil.setOnClickListener(View.OnClickListener {
            var cList = waitingDbManager.readData()
            for(c in cList){
                var canceledOrder= CanceledOrder(c.Hisse!!,c.Adet!!,c.Fiyat!!,c.IslemTipi!!)
                canceledDbManager.insertData(canceledOrder)
            }
            waitingDbManager.deleteAllData()
            bkl_emir_recyclerView.layoutManager= LinearLayoutManager(context)
            bkl_emir_recyclerView.adapter= RecyclerViewAdapterBekEmirlerim(bekleyenEmirler)
            navController = Navigation.findNavController(view)
            navController!!.navigate(R.id.action_blankFragment_self)
        })


        bkl_emir_recyclerView.layoutManager= LinearLayoutManager(context)
        bkl_emir_recyclerView.adapter= RecyclerViewAdapterBekEmirlerim(bekleyenEmirler)

    }
}