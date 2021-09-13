
package com.elifersumer.myapplication.fragments

import android.R.attr
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
import android.R.attr.label
import android.graphics.Paint
import com.github.mikephil.charting.charts.Chart


class KarsilamaFragment : Fragment()  {
    private lateinit var pieChart: PieChart
    private var list1 = mutableListOf<hisseler>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {/*
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
                    var h1=hisseler(stock.Name!!,R.drawable.header_logo,stock.Cost!!,stock.Amount!!,stock.PotentialBenefitRate!!,stock.PotentialBenefit!!,stock.Rate!!,stock.Price!!,stock.StockItem!!)
                    list1.add(h1)
                }
                val tourList = list1
                recyclerview.layoutManager=LinearLayoutManager(context)
                recyclerview.adapter= RecyclerViewAdapter(tourList)
                initPieChart()
                setDataToPieChart(list1)

            }

            override fun onFailure(call: Call<GetCustomerPortfolioByDateResponse?>?, t: Throwable?) {}
        })*/
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_karsilama, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pieChart = view.findViewById(R.id.pieChart)
        pieChart.setNoDataText("Veriler Yükleniyor");
        val paint: Paint =  pieChart.getPaint(Chart.PAINT_INFO)
        paint.textSize = 40f
        pieChart.invalidate()

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
        val colors: ArrayList<Int> = ArrayList()
        for(i in mutableList){
            dataEntries.add(PieEntry(i.tane.toFloat(),i.sh_name))
            val rnd = Random()
            colors.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)))
        }
        val dataSet = PieDataSet(dataEntries, "Results")
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 2f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(12f)
        pieChart.setExtraOffsets(15f, 15f, 15f, 15f)
        pieChart.setEntryLabelTextSize(5f)
        pieChart.setEntryLabelColor(Color.WHITE);

        pieChart.animateY(2000,Easing.EaseInOutQuad)
        pieChart.holeRadius = 0f
        pieChart.transparentCircleRadius = 0f
        pieChart.isDrawHoleEnabled = true
        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = " "
        val l = pieChart.legend
        pieChart.legend.isWordWrapEnabled = true
        pieChart.legend.isEnabled = true
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT // position
        l.formSize = 10f
        l.formToTextSpace = 0f
        l.form = Legend.LegendForm.LINE // form type : line, square, circle ..
        l.textSize = 10f
        l.orientation = Legend.LegendOrientation.VERTICAL // side by side or bottom to bottom
        l.isWordWrapEnabled = true
        pieChart.invalidate()


    }

}
