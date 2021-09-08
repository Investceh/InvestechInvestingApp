
package com.elifersumer.myapplication.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetCustomerPortfolioByDateParameters
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetOrderCustomerPortfolioByDateRequest
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateResponse
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.Stock
import com.elifersumer.myapplication.GetOrderList.Request.GetOrderListRequest
import com.elifersumer.myapplication.GetOrderList.Response.GetOrderListResponse
import com.elifersumer.myapplication.GetOrderList.Response.Order
import com.elifersumer.myapplication.GetOrderList.Retrofit.RetroService
import com.elifersumer.myapplication.Header
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapter
import com.elifersumer.myapplication.RetroInstance
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.fragment_karsilama.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.emptyList as emptyList

class KarsilamaFragment : Fragment()  {
    private lateinit var pieChart: PieChart
    private var list1 = mutableListOf<hisseler>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var instances=RetroInstance()

        var header = Header("c1c2a508fdf64c14a7b44edc9241c9cd","API","331eb5f529c74df2b800926b5f34b874","5252012362481156055")

        var getCustomerPortfolioByDateParameters= GetCustomerPortfolioByDateParameters(4723876,1,"2019-07-05T00:00:00")

        //var listParameters=ArrayList<GetOrderListParameters>()

        //listParameters.add(getOrderListParameters)

        var getOrderCustomerPortfolioByDateRequest= GetOrderCustomerPortfolioByDateRequest(header,
            arrayListOf(getCustomerPortfolioByDateParameters))

        var retrofit= RetroInstance.getRetrofitObject()?.create(com.elifersumer.myapplication.GetCustomerPortfolio.Retrofit.RetroService::class.java)
        var result : Call<GetCustomerPortfolioByDateResponse> = retrofit!!.GetPostValue(getOrderCustomerPortfolioByDateRequest)
        var stockList:List<Stock>

        result.enqueue(object : Callback<GetCustomerPortfolioByDateResponse?> {
            override fun onResponse(call: Call<GetCustomerPortfolioByDateResponse?>?, response: Response<GetCustomerPortfolioByDateResponse?>) {
                var data=response.body()!!.GetData()
                stockList=data?.StockList!!

                for(stock in stockList){
                    var h1=hisseler(stock.Name!!,R.drawable.header_logo,stock.Cost!!,stock.Amount!!,stock.PotentialBenefitRate!!)
                    list1.add(h1)
                }
                val tourList = list1
                recyclerview.layoutManager=LinearLayoutManager(context)
                recyclerview.adapter= RecyclerViewAdapter(tourList)
                initPieChart()
                setDataToPieChart(list1)

            }

            override fun onFailure(call: Call<GetCustomerPortfolioByDateResponse?>?, t: Throwable?) {}
        })

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_karsilama, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pieChart = view.findViewById(R.id.pieChart)

        //      val tourList = list1
            /*arrayListOf(
            hisseler("YAPI VE KREDİ BANKASI A.Ş", "YKBNK" ,R.drawable.header_logo, 20000.0 , 5 , 20.2),
            hisseler("İHLAS HOLDİNG A.Ş", "IHLAS" ,R.drawable.header_logo, 300000.5 , 7 , 1.3),
            hisseler("TÜRKİYE GARANTİ BANKASI A.Ş\n", "GARAN",R.drawable.header_logo, 200000.0 , 9 , 4.6)
        )*/
/*
        println(tourList?.get(0)?.name)
        recyclerview.layoutManager=LinearLayoutManager(context)
        recyclerview.adapter= RecyclerViewAdapter(tourList!!)
*/
    }


    private fun initPieChart() {

        pieChart.setUsePercentValues(true)
        pieChart.description.text = "Portfoy"
        //hollow pie chart
        pieChart.isDrawHoleEnabled = true
        pieChart.setTouchEnabled(false)
        pieChart.setDrawEntryLabels(false)
        //adding padding
        pieChart.setExtraOffsets(20f, 0f, 20f, 20f)
        pieChart.setUsePercentValues(true)
        pieChart.isRotationEnabled = false
        pieChart.setDrawEntryLabels(false)
        pieChart.legend.orientation = Legend.LegendOrientation.VERTICAL
        pieChart.legend.isWordWrapEnabled = true

    }
    private fun setDataToPieChart(mutableList: MutableList<hisseler>) {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        var total = mutableList.size
        val colors: ArrayList<Int> = ArrayList()
        for(i in mutableList){
            dataEntries.add(PieEntry(i.tane.toFloat(),i.sh_name))
            val rnd = Random()
            colors.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)))
        }

/*
        dataEntries.add(PieEntry(55f, "THYAO"))
        dataEntries.add(PieEntry(25f, "TUPRAS"))
        dataEntries.add(PieEntry(20f, "SASA"))
        dataEntries.add(PieEntry(5f, "PEGASUS"))

        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))
        colors.add(Color.parseColor("#FF8A65"))
        colors.add(Color.parseColor("#E6E6FA"))
*/
        val dataSet = PieDataSet(dataEntries, "Results")
        val data = PieData(dataSet)
        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        pieChart.invalidate()
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(2000, Easing.EaseInOutQuad)
        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Hisselerim"

    }

}
