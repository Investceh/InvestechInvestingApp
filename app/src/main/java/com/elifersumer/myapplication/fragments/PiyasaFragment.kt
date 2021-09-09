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
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import com.elifersumer.myapplication.LiveBorsa.Request.Header
import com.elifersumer.myapplication.LiveBorsa.Request.LiveBorsaRequest
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaData
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo
import com.elifersumer.myapplication.LiveBorsa.Service.CollectApiInstance
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*
import kotlinx.android.synthetic.main.fragment_karsilama.*
import kotlinx.android.synthetic.main.fragment_piyasa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PiyasaFragment : Fragment() {
    private var list1= mutableListOf<PiyasaData>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var header = Header("apikey 2Vu0SR2nyy8UB3MumXXj9z:0CTQqQA6LsVYD0ZGqifhlo")

        var liveBorsaRequest= LiveBorsaRequest(header)

        var retrofit= CollectApiInstance.getRetrofitObject()?.create(com.elifersumer.myapplication.LiveBorsa.Service.BorsaService::class.java)

        var result : Call<LiveBorsaResponse> = retrofit!!.GetPostValue(liveBorsaRequest)

        var borsaList:List<StockInfo>

        result.enqueue(object : Callback<LiveBorsaResponse?> {
            override fun onResponse(call: Call<LiveBorsaResponse?>?, response: Response<LiveBorsaResponse?>) {
                var data=response.body()!!.GetData()
                borsaList=data?.result!!

                for(stock in borsaList){
                    var satis = ((stock.prices!!)*(stock.rate!!)).toString()
                    var h1=PiyasaData("deg", stock.name!!, stock.pricestr!!, satis, stock.rate.toString())
                    list1.add(h1)
                }
                val all_hisse = list1
                piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
                piyasa_recyclerView.adapter= RecyclerViewAdapterPiyasa(all_hisse)
            }

            override fun onFailure(call: Call<LiveBorsaResponse?>?, t: Throwable?) {}
        })

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
                                            "1.48"),
            PiyasaData("deg","AKCNS","15.03","15.29",
                "-0.20")
        )
        piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
        piyasa_recyclerView.adapter= RecyclerViewAdapterPiyasa(all_hisse)

    }
}