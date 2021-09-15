package com.elifersumer.myapplication.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.WaitingDbManager
import com.elifersumer.myapplication.Database.WaitingOrder
import com.elifersumer.myapplication.MessageEvent
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.emir_tablayout
import kotlinx.android.synthetic.main.fragment_emirgiris.*
import kotlinx.android.synthetic.main.fragment_emirgiris.view.*
import kotlinx.android.synthetic.main.fragment_piyasa.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.w3c.dom.Text
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
            //Toast.makeText(this@EmirFragment.requireActivity(),"AŞKSIN ", Toast.LENGTH_SHORT).show()
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
                        if(/*tot_price <= /* kullanıcının yatırım hesabındaki para */0.0*/1 == 1){
                            Log.d("if:","a")
                            val bundle = Bundle()
                            bundle.putString("ger_isim",input_isim)
                            bundle.putString("ger_fiyat",input_fiyat)
                            bundle.putString("ger_adet",input_adet)
                            bundle.putString("ger_alisOrSatis","Alış")

                            var waitingOrder=WaitingOrder(input_isim,input_adet.toInt(),input_fiyat.toDouble(),"Alis")
                            var waitingDbManager=WaitingDbManager(this@EmirFragment.requireActivity(),db.writableDatabase)
                            waitingDbManager.insertData(waitingOrder)

                            /*val fragment = GerceklesenEmirFragment()
                            fragment.arguments = bundle
                            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,fragment)?.commit()
*/
                            /*
                                . transfer sayfasında yatırımdaki parasını azalt
                                . portföye yeni kart ekle(eğer o hisse için kullanıcının kartı varsa, sadece adedini arttır)
                            */
                        }else{
                            Toast.makeText(this@EmirFragment.requireActivity(),"Yetersiz Bakiye", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        var tot_price = input_adet.toDouble() * input_fiyat.toDouble()
                        if(/*tot_price <=*/ /* kullanıcının yatırım hesabındaki para */true){
                            Log.d("if2:","a")
                            val bundle = Bundle()
                            bundle.putString("bek_isim",input_isim)
                            bundle.putString("bek_fiyat",input_fiyat)
                            bundle.putString("bek_adet",input_adet)
                            bundle.putString("bek_alisOrSatis","Alış")
                            val fragment = BekleyenEmirFragment()
                            fragment.arguments = bundle
                            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,fragment)?.commit()
                            /*
                                . bekleyene yolla bu bilgileri
                                . transfer sayfasında yatırımdaki parasını azalt
                             */
                        }else{
                            Toast.makeText(this@EmirFragment.requireActivity(),"Yetersiz Bakiye", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else if (input_islem_tipi == "Satış"){
                    input_isim = hisseler.text.toString()
                    input_fiyat = fiyat.text.toString()
                    input_adet = adet.text.toString()


                    if(fiyat.text.toString() == alisFiyat.text.toString()){
                        val bundle = Bundle()
                        bundle.putString("ger_isim",input_isim)
                        bundle.putString("ger_fiyat",input_fiyat)
                        bundle.putString("ger_adet",input_adet)
                        bundle.putString("ger_alisOrSatis","Satış")
                        val fragment = GerceklesenEmirFragment()
                        fragment.arguments = bundle
                        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,fragment)?.commit()

                            /*

                                . transfer sayfasında yatırımdaki parasını azalt
                                . portföye yeni kart ekle(eğer o hisse için kullanıcının kartı varsa, sadece adedini arttır)
                            */

                    }else{
                        Log.d("if2:","a")
                        val bundle = Bundle()
                        bundle.putString("bek_isim",input_isim)
                        bundle.putString("bek_fiyat",input_fiyat)
                        bundle.putString("bek_adet",input_adet)
                        bundle.putString("bek_alisOrSatis","Satış")
                        val fragment = BekleyenEmirFragment()
                        fragment.arguments = bundle
                        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,fragment)?.commit()
                            /*

                                . transfer sayfasında yatırımdaki parasını arttır
                             */
                    }

                }


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


        val hisseler = resources.getStringArray(R.array.hisseler)
        val fiyatTipleri = resources.getStringArray(R.array.fiyatTipleri)
        val sureTipleri = resources.getStringArray(R.array.sureTipleri)
        var arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, hisseler)
        var arrayAdapter2 = ArrayAdapter(requireContext(),R.layout.dropdown_item, fiyatTipleri)
        var arrayAdapter3 = ArrayAdapter(requireContext(), R.layout.dropdown_item, sureTipleri)

        view.autoCompleteTextView.setAdapter(arrayAdapter)
        view.autoCompleteTextViewFiyatTipi.setAdapter(arrayAdapter2)
        view.autoCompleteTextViewSureTipi.setAdapter(arrayAdapter3)


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