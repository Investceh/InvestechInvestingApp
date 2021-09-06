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




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emirgiris, container, false)
    }
}