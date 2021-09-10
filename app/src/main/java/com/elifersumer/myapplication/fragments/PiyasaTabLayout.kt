package com.elifersumer.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.elifersumer.myapplication.FragmentAdapterEmir
import com.elifersumer.myapplication.R
import com.google.android.material.tabs.TabLayout

class PiyasaTabLayout : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_piyasa_tab_layout, container, false)
        var viewPager = view.findViewById(R.id.piyasa_viewpager) as ViewPager
        var tablayout = view.findViewById(R.id.piyasa_tablayout) as TabLayout
        val fragmentAdapter = FragmentAdapterEmir(childFragmentManager)
        fragmentAdapter.addFragment(PiyasaFragment(),title = "BORSA")
        fragmentAdapter.addFragment(DovizFragment(),title = "DÖVİZ")
        fragmentAdapter.addFragment(AltinFragment(),title = "ALTIN")
        fragmentAdapter.addFragment(KriptoFragment(),title = "KRİPTO")
        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
        // Inflate the layout for this fragment
        return view
    }

}