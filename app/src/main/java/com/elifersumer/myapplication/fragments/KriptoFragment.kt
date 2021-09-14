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
import com.elifersumer.myapplication.Cripto.Response.CriptoInfo
import com.elifersumer.myapplication.Cripto.Response.CriptoResponse
import com.elifersumer.myapplication.Cripto.Service.CriptoService
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


class KriptoFragment : Fragment() {
    private var list1= mutableListOf<PiyasaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var retrofit= CollectApiInstance.getRetrofitObject()?.create(CriptoService::class.java)

        var result : Call<CriptoResponse> = retrofit!!.GetPostValue()

        var kriptoList:List<CriptoInfo>

        result.enqueue(object : Callback<CriptoResponse?> {
            override fun onResponse(call: Call<CriptoResponse?>?, response: Response<CriptoResponse?>) {
                var data = response.body()!!.GetData()
                kriptoList=data!!
                for(kripto in kriptoList){
                    var priceString : String
                    val df = DecimalFormat("#,##0.00")
                    priceString = df.format(kripto.price).replace(',','.').reversed().replaceFirst('.',',').reversed()
                    var h1=PiyasaData("deg", kripto.code!!, priceString, kripto.changeHourstr!!, kripto.changeDaystr!!)
                    list1.add(h1)
                }
                // Inflate the layout for this fragment
                val all_hisse = list1
                piyasa_recyclerView.layoutManager= LinearLayoutManager(context)
                piyasa_recyclerView.adapter= RecyclerViewAdapterForAltin(all_hisse)
            }
            override fun onFailure(call: Call<CriptoResponse?>?, t: Throwable?) {

            }
        })


        return inflater.inflate(R.layout.fragment_kripto, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val drawable1: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.ic_rise_up_green, null)
        val textView = TextView(this.context)
        textView.setBackground(drawable1)
        super.onViewCreated(view, savedInstanceState)
    }

}