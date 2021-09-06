package com.elifersumer.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elifersumer.myapplication.R
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.content.res.ResourcesCompat

class TransferFragment : Fragment() {
    var cüzdan_yatırım = 1254.0
    var cüzdan_vadesiz = 5000.0
    var secilen_miktar_double = 0.0
    lateinit var hesap_bilgi: TextView
    lateinit var yatırım_bilgi: TextView

    lateinit var miktar: EditText

    lateinit var  islem: RadioGroup
    lateinit var vadesiz_yatırım: RadioButton
    lateinit var yatırım_vadesiz: RadioButton

    lateinit var oranlar: RadioGroup
    lateinit var rg_100: RadioButton

    lateinit var btn_tamam: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_transfer, container, false)
        hesap_bilgi = view.findViewById(R.id.hesap_bilgi) as TextView
        yatırım_bilgi = view.findViewById(R.id.yatırım_bilgi) as TextView

        islem = view.findViewById(R.id.islem) as RadioGroup
        vadesiz_yatırım = view.findViewById(R.id.vadesiz_yatırım) as RadioButton
        yatırım_vadesiz = view.findViewById(R.id.yatırım_vadesiz) as RadioButton

        oranlar = view.findViewById(R.id.oranlar) as RadioGroup
        rg_100 = view.findViewById(R.id.rg_100) as RadioButton

        btn_tamam = view.findViewById(R.id.btn_tamam) as Button

        hesap_bilgi.text = cüzdan_vadesiz.toString()
        yatırım_bilgi.text = cüzdan_yatırım.toString()

        miktar = view.findViewById(R.id.miktar) as EditText


        rg_100.setOnClickListener(View.OnClickListener {
            secilen_miktar_double = 0.0
            if(!vadesiz_yatırım.isChecked && !yatırım_vadesiz.isChecked){
                Toast.makeText(this@TransferFragment.requireActivity(),"Lütfen işlem seçiniz!",Toast.LENGTH_SHORT).show()
            }else {
                if (oranlar.checkedRadioButtonId != -1) {
                    if (rg_100.isChecked && vadesiz_yatırım.isChecked)
                        miktar.setText((cüzdan_vadesiz).toString())
                    else if (rg_100.isChecked && yatırım_vadesiz.isChecked)
                        miktar.setText((cüzdan_yatırım).toString())
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
            //Toast.makeText(this@TransferFragment.requireActivity(),"ahahahahahaha",Toast.LENGTH_SHORT).show()
            //val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button, null)
            //val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_selected, null)

            //btn_tamam.setBackground(drawable_selected)

            //
            //btn_tamam.setBackgroundResource(android.R.drawable.btn_default)
            if(!vadesiz_yatırım.isChecked && !yatırım_vadesiz.isChecked)
                Toast.makeText(this@TransferFragment.requireActivity(),"Lütfen işlem seçiniz!",Toast.LENGTH_SHORT).show()
            else{
                if(miktar.getText().toString() == ""){
                    Toast.makeText(this@TransferFragment.requireActivity(),"Lütfen miktar giriniz..",Toast.LENGTH_SHORT).show()
                }else{
                    var secilen_miktar = miktar.getText().toString()
                    secilen_miktar_double += secilen_miktar.toDouble()
                    if(islem.checkedRadioButtonId != -1) {
                        if (vadesiz_yatırım.isChecked) {
                            if(cüzdan_vadesiz >= secilen_miktar_double){
                                cüzdan_vadesiz -= secilen_miktar_double
                                cüzdan_yatırım += secilen_miktar_double
                                hesap_bilgi.setText(cüzdan_vadesiz.toString())
                                yatırım_bilgi.setText(cüzdan_yatırım.toString())
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
                                hesap_bilgi.setText(cüzdan_vadesiz.toString())
                                yatırım_bilgi.setText(cüzdan_yatırım.toString())
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
            secilen_miktar_double
        })

        // Inflate the layout for this fragment
        return view
    }

    private fun clearInputs() {
        miktar.setText("")
        oranlar.clearCheck()
        islem.clearCheck()
    }
}