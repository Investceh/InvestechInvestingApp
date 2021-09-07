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



        alisbtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@EmirFragment.requireActivity(),"Lütfen işlem seçiniz!", Toast.LENGTH_SHORT).show()
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