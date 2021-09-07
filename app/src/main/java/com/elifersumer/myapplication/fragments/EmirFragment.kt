package com.elifersumer.myapplication.fragments

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat.setBackground
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_emirgiris.view.*
import kotlinx.android.synthetic.main.fragment_piyasa.view.*


class EmirFragment : Fragment() {


    lateinit var alisbtn : RadioButton
    lateinit var satisbtn: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_emirgiris, container, false)
        alisbtn = view.findViewById(R.id.alisbtn) as RadioButton
        satisbtn = view.findViewById(R.id.satisbtn) as RadioButton

        val tamamBtn = view.findViewById(R.id.emirTamamButton) as Button

        val incrementBtn = view.findViewById(R.id.incrementFiyat) as Button
        val decrementBtn = view.findViewById(R.id.decrementFiyat) as Button

        val alisFiyat = view.findViewById(R.id.val_alis) as TextView
        val satisFiyat = view.findViewById(R.id.val_satis) as TextView
        val fiyat = view.findViewById(R.id.edtxt_fiyat) as EditText

        fiyat.setText(satisFiyat.text)

        alisbtn.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this@EmirFragment.requireActivity(),"Lütfen işlem seçiniz!", Toast.LENGTH_SHORT).show()

            fiyat.setText(satisFiyat.text)
        })

        satisbtn.setOnClickListener(View.OnClickListener {

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

        tamamBtn.setOnClickListener(View.OnClickListener {
            if(view.findViewById<EditText>(R.id.edtxt_adet).text.toString() == ""){
                Toast.makeText(this@EmirFragment.requireActivity(),"Lütfen adet giriniz!", Toast.LENGTH_SHORT).show()
            }
        })


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
}