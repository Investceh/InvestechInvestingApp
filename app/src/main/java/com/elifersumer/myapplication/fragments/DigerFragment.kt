package com.elifersumer.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_diger.view.*

class DigerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_diger, container, false)
        view.emirlerimBtn.setOnClickListener {
            makeCurrentFragment(BlankFragment())
        }

        return view
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        childFragmentManager.beginTransaction().apply {
            replace(R.id.blank_id,fragment)
            commit()
        }
}