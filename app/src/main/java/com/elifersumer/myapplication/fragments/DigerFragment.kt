package com.elifersumer.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.elifersumer.myapplication.R
import kotlinx.android.synthetic.main.fragment_diger.view.*

class DigerFragment : Fragment() {
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_diger, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.portföygcsBtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_karsilamaFragment)
        }
        view.findViewById<Button>(R.id.piyasagcsBtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_piyasaFragment)
        }
        view.findViewById<Button>(R.id.transfergcsBtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_transferFragment)
        }
        view.findViewById<Button>(R.id.emirGirisgcsBtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_emirFragment)
        }
        view.findViewById<Button>(R.id.emirlerimgcsBtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_blankFragment)
        }
        view.findViewById<Button>(R.id.anketgcsbtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_sorularFragment)
        }
        view.findViewById<Button>(R.id.haberlergcsBtn).setOnClickListener{
            navController!!.navigate(R.id.action_digerFragment_to_haberlerFragment)
        }
    }
}