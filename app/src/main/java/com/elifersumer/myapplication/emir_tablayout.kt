package com.elifersumer.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.elifersumer.myapplication.fragments.BekleyenEmirFragment
import com.elifersumer.myapplication.fragments.GerceklesenEmirFragment
import com.elifersumer.myapplication.fragments.IptalEmirFragment
import com.google.android.material.tabs.TabLayout

class emir_tablayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emir_tablayout)
        var viewPager = findViewById(R.id.emir_viewpager) as ViewPager
        var tablayout = findViewById(R.id.emir_tablayout) as TabLayout
        val fragmentAdapter = FragmentAdapterEmir(supportFragmentManager)
        fragmentAdapter.addFragment(GerceklesenEmirFragment(),title = "Gerceklesen")
        fragmentAdapter.addFragment(BekleyenEmirFragment(),title = "Bekleyen")
        fragmentAdapter.addFragment(IptalEmirFragment(),title = "Iptal")
        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
    }
}