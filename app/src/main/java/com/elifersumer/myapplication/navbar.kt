package com.elifersumer.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.elifersumer.myapplication.fragments.*
import kotlinx.android.synthetic.main.activity_navbar.*
import kotlinx.serialization.ExperimentalSerializationApi


class navbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navbar)
        val karsilamaFragment = KarsilamaFragment()
        val piyasaFragment = PiyasaFragment()
        val transferFragment = TransferFragment()
        val emirFragment = EmirFragment()

        val digerFragment = DigerFragment()
        val emirTablayout = emir_tablayout()
        val intent = Intent(this,emir_tablayout::class.java)

        makeCurrentFragment(karsilamaFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.home -> makeCurrentFragment(karsilamaFragment)
                R.id.piyasa -> makeCurrentFragment(piyasaFragment)
                R.id.transfer -> makeCurrentFragment(transferFragment)
                R.id.emir -> makeCurrentFragment(emirFragment)
                R.id.diger  -> makeCurrentFragment(BlankFragment())
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
}