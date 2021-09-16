package com.elifersumer.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_emirgiris.view.*
import kotlinx.android.synthetic.main.fragment_investrade.view.*


class investrade : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_investrade, container, false)
        val arrayname = arrayOf("BIST100","BIST030","USD/TRY","EUR/TRY","EUR/USD","AKBNK")
        var arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, arrayname)
        view.Enstruman.setAdapter(arrayAdapter)

        val arrayname2 = arrayOf("Model1","Model2","Model3")
        var arrayAdapter2 = ArrayAdapter(requireContext(),R.layout.dropdown_item, arrayname2)
        view.Model.setAdapter(arrayAdapter2)

        val arrayname3 = arrayOf("%0","%25","%50","%75","%100")
        var arrayAdapter3 = ArrayAdapter(requireContext(),R.layout.dropdown_item, arrayname3)
        view.portfoyAgr.setAdapter(arrayAdapter3)



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_investrade, container, false)
    }
}