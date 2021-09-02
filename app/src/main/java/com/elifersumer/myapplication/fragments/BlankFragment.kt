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
        fragmentAdapter.addFragment(BekleyenEmirFragment(),title = "Bekleyen")
        fragmentAdapter.addFragment(GerceklesenEmirFragment(),title = "Gerceklesen")
        fragmentAdapter.addFragment(IptalEmirFragment(),title = "Iptal")
        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
        // Inflate the layout for this fragment
        return view
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        childFragmentManager.beginTransaction().apply {
            replace(R.id.blank_id,fragment)
            commit()
        }

    /*override fun onResume() {
        super.onResume()
        func()
    }*/
    private fun func(){
        makeCurrentFragment(GerceklesenEmirFragment())
    }
}