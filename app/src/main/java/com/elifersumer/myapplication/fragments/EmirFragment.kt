package com.elifersumer.myapplication.fragments

<<<<<<< HEAD
import android.graphics.Color
import android.graphics.Typeface
import android.content.Context
=======
>>>>>>> master
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.CollectApi.CollectApiInstance
import com.elifersumer.myapplication.HisseInfo
import com.elifersumer.myapplication.LiveBorsa.Response.LiveBorsaResponse
import com.elifersumer.myapplication.LiveBorsa.Response.StockInfo
import com.elifersumer.myapplication.PiyasaData
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.RecyclerViewAdapterPiyasa
import kotlinx.android.synthetic.main.fragment_emirgiris.*
import kotlinx.android.synthetic.main.fragment_emirgiris.view.*
import kotlinx.android.synthetic.main.fragment_piyasa.*
import kotlinx.android.synthetic.main.fragment_piyasa.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat


class EmirFragment : Fragment() {
    lateinit var alisbtn : RadioButton
    lateinit var satisbtn: RadioButton
    lateinit var tamamBtn: Button
    lateinit var adet: EditText
    lateinit var hisseler: AutoCompleteTextView
    lateinit var rg: RadioGroup
    var nameList = ArrayList<String>()
    lateinit var hisseInfo:MutableList<HisseInfo>
    lateinit var t_alis : String
    lateinit var t_satis : String
    lateinit var t_miktar1:String
    lateinit var t_miktar2:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_emirgiris, container, false)
        val alisFiyat = view.findViewById(R.id.val_alis) as TextView
        val satisFiyat = view.findViewById(R.id.val_satis) as TextView
        val mik_1Fiyat = view.findViewById(R.id.val_miktar1) as TextView
        val mik_2Fiyat = view.findViewById(R.id.val_miktar2) as TextView

        var retrofit= CollectApiInstance.getRetrofitObject()?.create(com.elifersumer.myapplication.LiveBorsa.Service.BorsaService::class.java)

        var result : Call<LiveBorsaResponse> = retrofit!!.GetPostValue()

        var borsaList:List<StockInfo>

        result.enqueue(object : Callback<LiveBorsaResponse?> {
            override fun onResponse(call: Call<LiveBorsaResponse?>?, response: Response<LiveBorsaResponse?>) {
                var data = response.body()!!.GetData()
                borsaList=data!!
                for(stock in borsaList){
                    nameList.add(stock.name!!)
                    var satis = ((stock.price!!)*(stock.rate!! / 100)) + stock.price!!
                    var satisString : String
                    val df = DecimalFormat("#,##0.00")
                    satisString = df.format(satis)
                    var h1 = HisseInfo(stock.name!!,"10,542",stock.pricestr!!,satisString,"56,088")
                    hisseInfo.add(h1)
                }

                var arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, nameList)
                view.autoCompleteTextView.setAdapter(arrayAdapter)
                var name = autoCompleteTextView.text.toString()
                for(hisse in hisseInfo){
                    if(hisse.Name==name) {
                        t_alis = hisse.Alis!!
                        t_satis = hisse.Satis!!
                        t_miktar1 = hisse.Miktar1!!
                        t_miktar2 = hisse.Miktar2!!
                    }
                }
                alisFiyat.text=t_alis
                satisFiyat.text=t_satis
                mik_1Fiyat.text=t_miktar1
                mik_2Fiyat.text=t_miktar2
            }
            override fun onFailure(call: Call<LiveBorsaResponse?>?, t: Throwable?) {

            }
        })

        alisbtn = view.findViewById(R.id.alisbtn) as RadioButton
        satisbtn = view.findViewById(R.id.satisbtn) as RadioButton
        tamamBtn = view.findViewById(R.id.emirTamamButton) as Button

        val incrementBtn = view.findViewById(R.id.incrementFiyat) as Button
        val decrementBtn = view.findViewById(R.id.decrementFiyat) as Button

        adet = view.findViewById(R.id.edtxt_adet) as EditText


        val fiyat = view.findViewById(R.id.edtxt_fiyat) as EditText

        rg = view.findViewById(R.id.daily_weekly_button_view) as RadioGroup

        hisseler = view.findViewById(R.id.autoCompleteTextView) as AutoCompleteTextView

        fiyat.setText(satisFiyat.text)

        alisbtn.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this@EmirFragment.requireActivity(),"AŞKSIN ", Toast.LENGTH_SHORT).show()
            alisbtn.textSize = 16.toFloat()
            //alisbtn.setTextColor(Color.parseColor("#f5f5f5"))
            alisbtn.setTypeface(null, Typeface.BOLD)


            satisbtn.textSize = 15.toFloat()
            satisbtn.setTypeface(null, Typeface.NORMAL)


            fiyat.setText(satisFiyat.text)
        })

        satisbtn.setOnClickListener(View.OnClickListener {

            satisbtn.textSize = 16.toFloat()
            //alisbtn.setTextColor(Color.parseColor("#f5f5f5"))
            satisbtn.setTypeface(null, Typeface.BOLD)

            alisbtn.textSize = 15.toFloat()
            alisbtn.setTypeface(null, Typeface.NORMAL)

            fiyat.setText(alisFiyat.text)
        })


        incrementBtn.setOnClickListener(View.OnClickListener {
            fiyat.setText((fiyat.text.toString().toFloat() + 1).toString())
        })

        decrementBtn.setOnClickListener(View.OnClickListener {

            if(fiyat.text.toString().toFloat() > 1){
                fiyat.setText((fiyat.text.toString().toFloat() - 1).toString())
            }
            else{
                val x = 0
                fiyat.setText(x.toString())
            }
        })



        var input_islem_tipi = "Alış"
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

                val input_isim = hisseler.text.toString()
                val input_fiyat = fiyat.text.toString()
                val input_adet = adet.text.toString()

                //database olcak
                /* BekleyenEmirlerimData(
                     input_isim,
                     input_adet,
                     input_fiyat,
                     input_islem_tipi,
                     "İptal",
                     "Değiş"
                 )*/

            }
        }



        //val hisseler = resources.getStringArray(R.array.hisseler)
        val fiyatTipleri = resources.getStringArray(R.array.fiyatTipleri)
        val sureTipleri = resources.getStringArray(R.array.sureTipleri)

        var arrayAdapter2 = ArrayAdapter(requireContext(),R.layout.dropdown_item, fiyatTipleri)
        var arrayAdapter3 = ArrayAdapter(requireContext(), R.layout.dropdown_item, sureTipleri)


        view.autoCompleteTextViewFiyatTipi.setAdapter(arrayAdapter2)
        view.autoCompleteTextViewSureTipi.setAdapter(arrayAdapter3)


        // Inflate the layout for this fragment
        return view.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}