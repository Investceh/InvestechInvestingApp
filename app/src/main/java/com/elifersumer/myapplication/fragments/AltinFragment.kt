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
import com.elifersumer.myapplication.Parite.Response.PariteInfo
import com.elifersumer.myapplication.Parite.Response.PariteResponse
import com.elifersumer.myapplication.Parite.Service.DövizService
import com.elifersumer.myapplication.PiyasaData
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapterForAltin
import com.elifersumer.myapplication.RecyclerViewAdapterForDoviz
import kotlinx.android.synthetic.main.fragment_piyasa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat

class AltinFragment : Fragment() {
    private var list1= mutableListOf<PiyasaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var retrofit= CollectApiInstance.getRetrofitObject()?.create(GoldService::class.java)

        var result : Call<GoldPriceResponse> = retrofit!!.GetPostValue()

        var goldList:List<GoldInfo>

        result.enqueue(object : Callback<GoldPriceResponse?> {
            override fun onResponse(call: Call<GoldPriceResponse?>?, response: Response<GoldPriceResponse?>) {
                var data = response.body()!!.GetData()
                goldList=data!!
                for(gold in goldList){
                    var satisString : String
                    var alisString : String
                    val df = DecimalFormat("#,##0.00")
                    satisString = df.format(gold.selling)
                    alisString = df.format(gold.buying)

                    /*var buy = gold.buy!!.toDouble()
                    var sell = gold.sell!!.toDouble()
                    var rate : Double

                    if(gold.name=="Cumhuriyet Altını"){
                        rate = -0.09
                    }else if(gold.name=="Yarım Altın"){
                        rate = -0.19
                    }else if(gold.name=="Çeyrek Altın"){
                        rate = -0.12
                    }else{
                        rate = (buy-sell)/buy
                    }
                    var rateString : String
                    rateString=df.format(rate) */

                    var h1=PiyasaData("deg", gold.name!!, alisString.replace('.',','),satisString.replace('.',','), gold.rate.toString())
                    list1.add(h1)
                }
                // Inflate the layout for this fragment
                val all_hisse = list1
                piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
                piyasa_recyclerView.adapter= RecyclerViewAdapterForAltin(all_hisse)
            }
            override fun onFailure(call: Call<GoldPriceResponse?>?, t: Throwable?) {}
        })


        return inflater.inflate(R.layout.fragment_altin, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val drawable1: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_green, null)
        val textView = TextView(this.context)
        textView.setBackground(drawable1)
        super.onViewCreated(view, savedInstanceState)
    }
}
