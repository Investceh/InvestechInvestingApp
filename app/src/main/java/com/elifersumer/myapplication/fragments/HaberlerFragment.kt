package com.elifersumer.myapplication.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import com.elifersumer.myapplication.CollectApi.CollectApiInstance
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetCustomerPortfolioByDateParameters
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetOrderCustomerPortfolioByDateRequest
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateResponse
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.Stock
import com.elifersumer.myapplication.GetNews.Response.GetNewsResponse
import com.elifersumer.myapplication.GetNews.Response.News
import com.elifersumer.myapplication.GetNews.Service.NewsService
import kotlinx.android.synthetic.main.fragment_karsilama.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.net.URL

class HaberlerFragment : Fragment() {
    private var list1 = mutableListOf<haberler>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var retrofit= CollectApiInstance.getRetrofitObject()?.create(NewsService::class.java)
        var result : Call<GetNewsResponse> = retrofit!!.GetPostValue()
        var haberList:List<News>

        result.enqueue(object : Callback<GetNewsResponse?> {
            override fun onResponse(call: Call<GetNewsResponse?>?, response: Response<GetNewsResponse?>) {
                var data=response.body()!!
                haberList=data?.result!!
                for(haber in haberList){
/*
                    var url :URL = URL(haber.image)
*/

                  //  var bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    var link = URL(haber.url)
                    var h1=haberler(haber.name!!,haber.description!!,haber.image!!,haber.source!!,haber.url!!)
                    list1.add(h1)
                }
                val tourList = list1
                recyclerview.layoutManager= LinearLayoutManager(context)
                recyclerview.adapter= RecyclerViewAdapterForHaberler(tourList)
            }

            override fun onFailure(call: Call<GetNewsResponse?>?, t: Throwable?) {

            }
        })
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_haberler, container, false)

        return view
    }
}