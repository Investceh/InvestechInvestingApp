package com.elifersumer.myapplication

import android.content.Context
import android.content.LocusId
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.fragment_karsilama.*
import lecho.lib.hellocharts.model.Line

class karsilama : AppCompatActivity() {
    private lateinit var pieChart: PieChart
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<hisseler>
    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>


    lateinit var listViw : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)
        //val listView = findViewById<ListView>(R.id.listView)
        //val col = Color.parseColor("#000000")
        //listView.setBackgroundColor(col)
        //listView.adapter = customAdaptor(this)
        imageId = arrayOf(
            R.drawable.tl,
            R.drawable.euro,
            R.drawable.dolar
        )
        heading = arrayOf(
            "Turkish Liras",
            "Euro",
            "Dolar"
        )
        newRecyclerView = findViewById(R.id.recycle)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<hisseler>()
        getUserData()

    }

    private fun getUserData() {
        for (i in imageId.indices){
            val  news = hisseler(imageId[i],heading[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)

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
    private fun setDataToPieChart() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(72f, "Android"))
        dataEntries.add(PieEntry(26f, "Ios"))
        dataEntries.add(PieEntry(2f, "Other"))
        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))
        colors.add(Color.parseColor("#FF8A65"))
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
        pieChart.animateY(1400, Easing.EaseInOutQuad)
        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Mobile OS Market share"


    }


    private class customAdaptor(context: Context): BaseAdapter() {
        private val mContext : Context

        init{
            this.mContext = context
        }
        override fun getCount(): Int {
            TODO("Not yet implemented")
            return 5
        }

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
            return "Test String"
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            TODO("Not yet implemented")
            val text = TextView(mContext)
            text.text = "Here is there"
            return text
        }
    }
}
