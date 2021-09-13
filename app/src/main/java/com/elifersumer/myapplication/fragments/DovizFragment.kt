package com.elifersumer.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.CollectApi.CollectApiInstance
import com.elifersumer.myapplication.GoldPrice.Response.GoldInfo
import com.elifersumer.myapplication.GoldPrice.Response.GoldPriceResponse
import com.elifersumer.myapplication.GoldPrice.Service.GoldService
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo
import com.elifersumer.myapplication.Parite.Response.PariteInfo
import com.elifersumer.myapplication.Parite.Response.PariteResponse
import com.elifersumer.myapplication.Parite.Service.DövizService
import com.elifersumer.myapplication.PiyasaData
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapterForDoviz
import kotlinx.android.synthetic.main.fragment_piyasa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat

class DovizFragment : Fragment() {
    private var list1= mutableListOf<PiyasaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*var retrofit= CollectApiInstance.getRetrofitObject()?.create(DövizService::class.java)

        var result : Call<PariteResponse> = retrofit!!.GetPostValue()

        var pariteList:List<PariteInfo>

        result.enqueue(object : Callback<PariteResponse?> {
            override fun onResponse(call: Call<PariteResponse?>?, response: Response<PariteResponse?>) {
                var data = response.body()!!.GetData()
                pariteList=data!!
                for(parite in pariteList){
                    var satisString : String
                    var alisString : String
                    val df = DecimalFormat("#,##0.00")
                    satisString = df.format(parite.selling)
                    alisString = df.format(parite.buying)

                    var h1=PiyasaData("deg", parite.name!!, alisString.replace('.',','),satisString.replace('.',','), parite.rate!!.toString())
                    list1.add(h1)
                }
                // Inflate the layout for this fragment
                val all_hisse = list1
                piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
                piyasa_recyclerView.adapter= RecyclerViewAdapterForDoviz(all_hisse)
            }
            override fun onFailure(call: Call<PariteResponse?>?, t: Throwable?) {}
        })*/

        return inflater.inflate(R.layout.fragment_doviz, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val drawable1: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_green, null)
        val textView = TextView(this.context)
        textView.setBackground(drawable1)
        super.onViewCreated(view, savedInstanceState)
    }
}
