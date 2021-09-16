package com.elifersumer.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import com.elifersumer.myapplication.Database.AccountInfo
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.AccDbManager
import com.elifersumer.myapplication.Database.Managers.DoneDbManager
import com.elifersumer.myapplication.GetAccountList.Request.GetAccountListParameters
import com.elifersumer.myapplication.GetAccountList.Request.GetAccountListRequest
import com.elifersumer.myapplication.GetAccountList.Response.Account
import com.elifersumer.myapplication.GetAccountList.Response.GetAccountListResponse
import com.elifersumer.myapplication.GetAccountList.Retrofit.AccountService
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetCustomerPortfolioByDateParameters
import com.elifersumer.myapplication.GetCustomerPortfolio.Request.GetOrderCustomerPortfolioByDateRequest
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.GetCustomerPortfolioByDateResponse
import com.elifersumer.myapplication.GetCustomerPortfolio.Response.Stock
import kotlinx.android.synthetic.main.fragment_karsilama.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat

class TransferFragment : Fragment() {
    var cüzdan_yatırım:Double=0.0
    var cüzdan_vadesiz:Double=0.0
    var secilen_miktar_double = 0.0
    val df = DecimalFormat("#,##0.00")
    lateinit var hesap_bilgi: TextView
    lateinit var yatırım_bilgi: TextView

    lateinit var miktar: EditText

    lateinit var  islem: RadioGroup
    lateinit var vadesiz_yatırım: RadioButton
    lateinit var yatırım_vadesiz: RadioButton

    lateinit var oranlar: RadioGroup
    lateinit var rg_100: RadioButton

    lateinit var btn_tamam: Button
    private var list1 = arrayListOf<hesaplar>()
    private var list2 = arrayListOf<hesaplar>()

    val db by lazy { DbHelper(this@TransferFragment.requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                var accDbManager = AccDbManager(this@TransferFragment.requireActivity(),db.readableDatabase)
                var accList=accDbManager.readData()
                cüzdan_vadesiz= accList[0].VadesizBakiye!!
                cüzdan_yatırım = accList[0].YatirimBakiye!!

        val view =  inflater.inflate(R.layout.fragment_transfer, container, false)
        hesap_bilgi = view.findViewById(R.id.hesap_bilgi) as TextView
        yatırım_bilgi = view.findViewById(R.id.yatırım_bilgi) as TextView

        islem = view.findViewById(R.id.islem) as RadioGroup
        vadesiz_yatırım = view.findViewById(R.id.vadesiz_yatırım) as RadioButton
        yatırım_vadesiz = view.findViewById(R.id.yatırım_vadesiz) as RadioButton

        oranlar = view.findViewById(R.id.oranlar) as RadioGroup
        rg_100 = view.findViewById(R.id.rg_100) as RadioButton

        btn_tamam = view.findViewById(R.id.btn_tamam) as Button

        Log.d("veri2:",cüzdan_vadesiz.toString())


        miktar = view.findViewById(R.id.miktar) as EditText

        Log.d("veri:",cüzdan_vadesiz.toString())
        var hesapBilgi = df.format(cüzdan_vadesiz).replace(',','.').reversed().replaceFirst('.',',').reversed()
        var yatirimBilgi = df.format(cüzdan_yatırım).replace(',','.').reversed().replaceFirst('.',',').reversed()


        hesap_bilgi.text = hesapBilgi.toString() + " ₺"
        yatırım_bilgi.text = yatirimBilgi.toString() + " ₺"
        var vadesiz_isim = view?.findViewById(R.id.vadesiz_isim) as TextView
        var yatirim_isim = view?.findViewById(R.id.yatirim_isim) as TextView
        vadesiz_isim.text = "Hürol ULUÖZ"
        yatirim_isim.text = "Hürol ULUÖZ"
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


        rg_100.setOnClickListener(View.OnClickListener {
            secilen_miktar_double = 0.0
            if(!vadesiz_yatırım.isChecked && !yatırım_vadesiz.isChecked){
                Toast.makeText(this@TransferFragment.requireActivity(),"Lütfen işlem seçiniz!",Toast.LENGTH_SHORT).show()
            }else {
                if (oranlar.checkedRadioButtonId != -1) {
                    if (rg_100.isChecked && vadesiz_yatırım.isChecked) {
                        var test1 = df.format(cüzdan_vadesiz).toString().replace(',','.').reversed().replaceFirst('.',',').reversed()
                        miktar.setText(test1)
                    }
                    else if (rg_100.isChecked && yatırım_vadesiz.isChecked) {
                        var test2 = df.format(cüzdan_yatırım).toString().replace(',','.').reversed().replaceFirst('.',',').reversed()
                        miktar.setText(test2)
                    }
                }
            }
        })

        vadesiz_yatırım.setOnClickListener(View.OnClickListener {
            oranlar.clearCheck()
            miktar.setText("")
        })

        yatırım_vadesiz.setOnClickListener(View.OnClickListener {
            oranlar.clearCheck()
            miktar.setText("")
        })

        btn_tamam.setOnClickListener(View.OnClickListener {

            if(!vadesiz_yatırım.isChecked && !yatırım_vadesiz.isChecked)
                Toast.makeText(this@TransferFragment.requireActivity(),"Lütfen işlem seçiniz!",Toast.LENGTH_SHORT).show()
            else{
                if(miktar.getText().toString() == ""){
                    Toast.makeText(this@TransferFragment.requireActivity(),"Lütfen miktar giriniz..",Toast.LENGTH_SHORT).show()
                }else{
                    var secilen_miktar = miktar.getText().toString()
                    secilen_miktar_double += string_fix(secilen_miktar).toDouble()

                    //secilen_miktar_double += secilen_miktar.toDouble()
                    if(islem.checkedRadioButtonId != -1) {
                        if (vadesiz_yatırım.isChecked) {
                            if(cüzdan_vadesiz!! >= secilen_miktar_double){
                                cüzdan_vadesiz -= secilen_miktar_double
                                cüzdan_yatırım += secilen_miktar_double
                                accDbManager.updateBalance(cüzdan_yatırım,cüzdan_vadesiz)
                                hesap_bilgi.setText(df.format(cüzdan_vadesiz).toString().replace(',','.').reversed().replaceFirst('.',',').reversed() + " ₺")
                                yatırım_bilgi.setText(df.format(cüzdan_yatırım).toString().replace(',','.').reversed().replaceFirst('.',',').reversed() + " ₺")
                                //btn_tamam.setBackground(drawable)
                                clearInputs()
                            }else{
                                Toast.makeText(this@TransferFragment.requireActivity(),"Yetersiz bakiye..",Toast.LENGTH_SHORT).show()
                                oranlar.clearCheck()
                                miktar.setText("")
                            }

                        } else if (yatırım_vadesiz.isChecked) {
                            if(cüzdan_yatırım >= secilen_miktar_double){
                                cüzdan_vadesiz += secilen_miktar_double
                                cüzdan_yatırım -= secilen_miktar_double
                                accDbManager.updateBalance(cüzdan_yatırım,cüzdan_vadesiz)
                                //buraa
                                hesap_bilgi.setText(df.format(cüzdan_vadesiz).toString().replace(',','.').reversed().replaceFirst('.',',').reversed() + " ₺")
                                yatırım_bilgi.setText(df.format(cüzdan_yatırım).toString().replace(',','.').reversed().replaceFirst('.',',').reversed() + " ₺")
                                clearInputs()
                            }
                            else{
                                Toast.makeText(this@TransferFragment.requireActivity(),"Yetersiz bakiye..",Toast.LENGTH_SHORT).show()
                                oranlar.clearCheck()
                                miktar.setText("")
                            }
                        }
                    }
                }
            }
            secilen_miktar_double = 0.0
        })
        return view
    }

    private fun clearInputs() {
        miktar.setText("")
        oranlar.clearCheck()
        islem.clearCheck()
    }
}