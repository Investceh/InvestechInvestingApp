package com.elifersumer.myapplication.fragments

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import com.elifersumer.myapplication.CollectApi.CollectApiInstance
import com.elifersumer.myapplication.Database.DoneOrder
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.AccDbManager

import com.elifersumer.myapplication.Database.Managers.DoneDbManager
import com.elifersumer.myapplication.Database.Managers.WaitingDbManager
import com.elifersumer.myapplication.Database.WaitingOrder
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo
import kotlinx.android.synthetic.main.fragment_emirgiris.*
import kotlinx.android.synthetic.main.fragment_emirgiris.view.*
import kotlinx.android.synthetic.main.fragment_piyasa.*
import kotlinx.android.synthetic.main.fragment_piyasa.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat


class EmirFragment : Fragment() {
    val db by lazy { DbHelper(this@EmirFragment.requireActivity()) }
    lateinit var messageTextView: EditText
    lateinit var alisbtn : RadioButton
    lateinit var satisbtn: RadioButton
    lateinit var tamamBtn: Button
    lateinit var adet: EditText
    lateinit var hisseler: AutoCompleteTextView
    lateinit var rg: RadioGroup
    val df = DecimalFormat("#,##0.00")
    var messageToDisplay:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_emirgiris, container, false)
        var accDbManager=AccDbManager(this@EmirFragment.requireActivity(),db.readableDatabase)
        var balanceList=accDbManager.readData()
        var cüzdan_yatırım=balanceList[0].YatirimBakiye
        var cüzdan_vadesiz=balanceList[0].VadesizBakiye

        val args = this.arguments
        val satisData = args?.get("satis")
        val alisData = args?.get("alis")
        val isimData = args?.get("isim")
        val alisOrSatis = args?.get("alisOrSatis")
        val farkData = args?.get("fark")
        Log.d("satis:",satisData.toString())

        alisbtn = view.findViewById(R.id.alisbtn) as RadioButton
        satisbtn = view.findViewById(R.id.satisbtn) as RadioButton
        tamamBtn = view.findViewById(R.id.emirTamamButton) as Button

        val incrementBtn = view.findViewById(R.id.incrementFiyat) as Button
        val decrementBtn = view.findViewById(R.id.decrementFiyat) as Button
        val farkTextView = view.findViewById(R.id.val_miktar2) as TextView

        adet = view.findViewById(R.id.edtxt_adet) as EditText

        val alisFiyat = view.findViewById(R.id.val_alis) as TextView
        val satisFiyat = view.findViewById(R.id.val_satis) as TextView
        val fiyat = view.findViewById(R.id.edtxt_fiyat) as EditText

        rg = view.findViewById(R.id.daily_weekly_button_view) as RadioGroup

        hisseler = view.findViewById(R.id.autoCompleteTextView) as AutoCompleteTextView

        hisseler.setText(isimData.toString())


        var input_islem_tipi = "Alış"

        alisFiyat.text = alisData.toString()
        if(alisData == null){
            alisFiyat.text = "20,03"
        }
        satisFiyat.text = satisData.toString()
        if(satisData == null){
            satisFiyat.text = "20,05"
        }

        if (isimData == null){
            hisseler.setText("EREGL")
        }
        farkTextView.text = farkData.toString()
        if(farkData == null){
            farkTextView.text = "%0.07"
        }
        if (alisOrSatis == "satis"){
            input_islem_tipi = "Satış"
            fiyat.setText(alisData.toString())
            if(alisData == null){
                fiyat.setText("20,05")
            }
            satisbtn.isChecked = true
        }
        else{
            input_islem_tipi == "Alış"
            fiyat.setText(satisData.toString())
            if(satisData == null){
                fiyat.setText("20,03")
            }
            alisbtn.isChecked = true
        }


        alisbtn.setOnClickListener(View.OnClickListener {
            alisbtn.textSize = 16.toFloat()
            //alisbtn.setTextColor(Color.parseColor("#f5f5f5"))
            alisbtn.setTypeface(null, Typeface.BOLD)


            satisbtn.textSize = 15.toFloat()
            satisbtn.setTypeface(null, Typeface.NORMAL)


            fiyat.setText(satisFiyat.text)
        })
        fun string_fix(inputstr : String): String {
            var var1 = ""
            for (i in inputstr){
                if (i == ','){
                    var1 += '.'
                }
                else if (i != '.'){
                    var1 += i
                }
            }
            return var1
        }


        satisbtn.setOnClickListener(View.OnClickListener {

            satisbtn.textSize = 16.toFloat()
            //alisbtn.setTextColor(Color.parseColor("#f5f5f5"))
            satisbtn.setTypeface(null, Typeface.BOLD)

            alisbtn.textSize = 15.toFloat()
            alisbtn.setTypeface(null, Typeface.NORMAL)

            fiyat.setText(alisFiyat.text)
        })


        incrementBtn.setOnClickListener(View.OnClickListener {
            var fiyat2 = string_fix(fiyat.text.toString())
            var fiyat3 = fiyat2.toFloat() + 1
            fiyat2 = df.format(fiyat3).replace(',','.').reversed().replaceFirst('.',',').reversed()
            fiyat.setText(fiyat2)
        })

        decrementBtn.setOnClickListener(View.OnClickListener {

            if(string_fix(fiyat.text.toString()).toFloat() > 1){
                var fiyat2 = string_fix(fiyat.text.toString())
                var fiyat3 = fiyat2.toFloat() - 1
                fiyat2 = df.format(fiyat3).replace(',','.').reversed().replaceFirst('.',',').reversed()
                fiyat.setText(fiyat2)
            }
            else{
                val x = 0
                fiyat.setText(x.toString())
            }
        })



        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{radioGroup, i ->
            input_islem_tipi = ""
            when(i) {
                R.id.alisbtn -> { input_islem_tipi = "Alış" }
                R.id.satisbtn -> { input_islem_tipi = "Satış" }
            }
        })


        tamamBtn.setOnClickListener {
            if(view.findViewById<EditText>(R.id.edtxt_adet).text.toString() == ""){
                Toast.makeText(this@EmirFragment.requireActivity(),"Lütfen adet giriniz!", Toast.LENGTH_SHORT).show()
            }else {

                val input_isim:String
                val input_fiyat:String
                val input_adet:String

                if(input_islem_tipi == "Alış"){
                    input_isim = hisseler.text.toString()
                    input_fiyat = fiyat.text.toString()
                    input_adet = adet.text.toString()

                    var input_fiyat2 = string_fix(input_fiyat)

                    if(fiyat.text.toString() == satisFiyat.text.toString()){

                        //profile update
                        var tot_price = input_adet.toDouble() * input_fiyat2.toDouble()

                        if(tot_price <= cüzdan_yatırım!!){
                            var yatirim = cüzdan_yatırım!!-tot_price
                            var doneOrder= DoneOrder(input_isim,input_adet,input_fiyat,"Alış")
                            var doneDbManager= DoneDbManager(this@EmirFragment.requireActivity(),db.writableDatabase)
                            doneDbManager.insertData(doneOrder)
                            accDbManager.updateBalance(yatirim,cüzdan_vadesiz!!)
                        }
                        else{
                            Toast.makeText(this@EmirFragment.requireActivity(),"Yetersiz Bakiye", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        var input_fiyat2 = string_fix(input_fiyat)
                        var tot_price = input_adet.toDouble() * input_fiyat2.toDouble()
                        if(tot_price <=cüzdan_yatırım!!){
                            var waitingOrder= WaitingOrder(input_isim,input_adet,input_fiyat,"Alış")
                            var waitDbManager= WaitingDbManager(this@EmirFragment.requireActivity(),db.writableDatabase)
                            waitDbManager.insertData(waitingOrder)
                        }else{
                            Toast.makeText(this@EmirFragment.requireActivity(),"Yetersiz Bakiye", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else if (input_islem_tipi == "Satış"){
                    input_isim = hisseler.text.toString()
                    input_fiyat = fiyat.text.toString()
                    input_adet = adet.text.toString()
                    var input_fiyat2 = string_fix(input_fiyat)
                    var tot_price = input_adet.toDouble() * input_fiyat2.toDouble()
                    var yatirim2 = cüzdan_yatırım!!+tot_price

                    if(fiyat.text.toString() == alisFiyat.text.toString()){

                        var doneOrder= DoneOrder(input_isim,input_adet,input_fiyat,"Satış")
                        var doneDbManager= DoneDbManager(this@EmirFragment.requireActivity(),db.writableDatabase)
                        doneDbManager.insertData(doneOrder)

                        accDbManager.updateBalance(yatirim2,cüzdan_vadesiz!!)

                    }else{
                        var waitingOrder= WaitingOrder(input_isim,input_adet,input_fiyat,"Satış")
                        var waitDbManager= WaitingDbManager(this@EmirFragment.requireActivity(),db.writableDatabase)
                        waitDbManager.insertData(waitingOrder)
                    }

                }
            //database oldu
            }
        }
        var list1= mutableListOf<PiyasaData>()
        var isimList= mutableListOf<String>()
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
                    satisString = df.format(satis).replace(',','.').reversed().replaceFirst('.',',').reversed()

                    var h1= PiyasaData("deg", stock.name!!, stock.pricestr!!,satisString, stock.rate.toString())
                    list1.add(h1)
                    isimList.add(stock.name!!)
                }
            }
            override fun onFailure(call: Call<LiveBorsaResponse?>?, t: Throwable?) {
            }
        })
        var isimList2 = mutableListOf<String>()
        var doneDbManager = DoneDbManager(this@EmirFragment.requireActivity(),db.readableDatabase)
        var doneList=doneDbManager.readData()
        for(done in doneList){
            if(done.IslemTipi=="Satış"){
                isimList2.add(done.Hisse!!)
            }
        }
        val hisseler = resources.getStringArray(R.array.hisseler)
        val fiyatTipleri = resources.getStringArray(R.array.fiyatTipleri)
        val sureTipleri = resources.getStringArray(R.array.sureTipleri)
        var arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, isimList)
        view.autoCompleteTextView.setAdapter(arrayAdapter)
        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.alisbtn -> {
                    arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, isimList)
                    view.autoCompleteTextView.setAdapter(arrayAdapter)
                }
                R.id.satisbtn-> {
                    Log.d("a","a")
                    arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, isimList2)
                    view.autoCompleteTextView.setAdapter(arrayAdapter)
                }
            }
        })

        var arrayAdapter2 = ArrayAdapter(requireContext(),R.layout.dropdown_item, fiyatTipleri)
        var arrayAdapter3 = ArrayAdapter(requireContext(), R.layout.dropdown_item, sureTipleri)

        view.autoCompleteTextView.setOnClickListener {
            Log.d("baslik:","a")
        }
        view.autoCompleteTextViewFiyatTipi.setAdapter(arrayAdapter2)
        view.autoCompleteTextViewSureTipi.setAdapter(arrayAdapter3)
        Log.d("baslik2:",view.autoCompleteTextView.text.toString())
        view.autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            alisFiyat.text = list1.get(position).alis
            satisFiyat.text = list1.get(position).satis
            farkTextView.text = list1.get(position).fark
            if (input_islem_tipi == "Alış"){
             fiyat.setText(list1.get(position).satis)
            }
            if (input_islem_tipi == "Satış"){
                fiyat.setText(list1.get(position).alis)
            }
        }
        // Inflate the layout for this fragment
        return view.rootView
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
        messageToDisplay = event.message
        Log.d("deneme1:",event.message)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}