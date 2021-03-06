package com.elifersumer.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.elifersumer.myapplication.fragments.*
import kotlinx.android.synthetic.main.activity_navbar.*
import kotlinx.android.synthetic.main.fragment_diger.*


class navbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navbar)
        val karsilamaFragment = KarsilamaFragment()
        val piyasaFragment = PiyasaFragment()
        val transferFragment = TransferFragment()
        val emirFragment = EmirFragment()
        val blankFragment = BlankFragment()
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
                R.id.diger  -> makeCurrentFragment(digerFragment)

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