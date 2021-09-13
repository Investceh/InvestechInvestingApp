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
import com.elifersumer.myapplication.PiyasaData
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapterForKripto
import kotlinx.android.synthetic.main.fragment_kripto.*
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
        println("zaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafsafasadsasd")

        var kriptoList:List<CriptoInfo>
        result.enqueue(object : Callback<CriptoResponse?> {
            override fun onResponse(call: Call<CriptoResponse?>?, response: Response<CriptoResponse?>) {
                var data = response.body()!!.GetData()
                kriptoList=data!!
                println("zaaaaaaaaaaaaaaaa***4*4*4*4*")
                for(kripto in kriptoList){
                    var priceString : String
                    val df = DecimalFormat("#,##0.00")
                    priceString = df.format(kripto.price)
<<<<<<< HEAD
=======

>>>>>>> master
                    var h1=PiyasaData("deg", kripto.code!!, priceString.replace('.',','),kripto.changeHourstr!!, kripto.changeDaystr!!)
                    list1.add(h1)
                }
                // Inflate the layout for this fragment
                val all_hisse = list1
                kripto_recyclerView.layoutManager= LinearLayoutManager(context)
                kripto_recyclerView.adapter= RecyclerViewAdapterForKripto(all_hisse)
            }
            override fun onFailure(call: Call<CriptoResponse?>?, t: Throwable?) {
                println("!!!!!!ERRORRROORRRRR")

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