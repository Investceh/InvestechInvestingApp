package com.elifersumer.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo
import com.elifersumer.myapplication.CollectApi.CollectApiInstance
import kotlinx.android.synthetic.main.fragment_piyasa.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat


class PiyasaFragment : Fragment() {
    private var list1= mutableListOf<PiyasaData>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var retrofit= CollectApiInstance.getRetrofitObject()?.create(com.elifersumer.myapplication.LiveBorsa.Service.BorsaService::class.java)

        var result : Call<LiveBorsaResponse> = retrofit!!.GetPostValue()

        var borsaList:List<StockInfo>

        result.enqueue(object : Callback<LiveBorsaResponse?> {
            override fun onResponse(call: Call<LiveBorsaResponse?>?, response: Response<LiveBorsaResponse?>) {
                var data = response.body()!!.GetData()
                borsaList=data!!
                for(stock in borsaList){
                    var satis = ((stock.price!!)*(stock.rate!! / 100)) + stock.price!!
                    var satisString : String
                    val df = DecimalFormat("#,##0.00")
                    satisString = df.format(satis)
                    var h1=PiyasaData("deg", stock.name!!, stock.pricestr!!,satisString.replace('.',','), stock.rate.toString())
                    list1.add(h1)
                }
                val all_hisse = list1
                piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
                piyasa_recyclerView.adapter= RecyclerViewAdapterPiyasa(all_hisse)
            }
            override fun onFailure(call: Call<LiveBorsaResponse?>?, t: Throwable?) {

            }
        })

        val view = inflater.inflate(R.layout.fragment_piyasa, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event:MessageEvent){
        Log.d("deneme2:",event.message)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val drawable1: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_green, null)
        val textView = TextView(this.context)
        textView.setBackground(drawable1)
        super.onViewCreated(view, savedInstanceState)

        /* val all_hisse = mutableListOf(PiyasaData(
             "deg","ALKIM","15.04","15.03",
             "1.48"),
             PiyasaData("deg","AKCNS","15.03","15.29",
                 "-0.20"))

        piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
        piyasa_recyclerView.adapter= RecyclerViewAdapterPiyasa(all_hisse)*/
    }
}