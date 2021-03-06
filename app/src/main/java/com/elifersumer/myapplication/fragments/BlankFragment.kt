package com.elifersumer.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.elifersumer.myapplication.FragmentAdapterEmir
import com.elifersumer.myapplication.R
import com.google.android.material.tabs.TabLayout

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.activity_emir_tablayout, container, false)
        var viewPager = view.findViewById(R.id.emir_viewpager) as ViewPager
        var tablayout = view.findViewById(R.id.emir_tablayout) as TabLayout
        val fragmentAdapter = FragmentAdapterEmir(childFragmentManager)
        fragmentAdapter.addFragment(BekleyenEmirFragment(),title = "BEKLEYEN")
        fragmentAdapter.addFragment(GerceklesenEmirFragment(),title = "GERÇEKLEŞEN")
        fragmentAdapter.addFragment(IptalEmirFragment(),title = "İPTAL")
        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
        // Inflate the layout for this fragment
        return view
    }
}