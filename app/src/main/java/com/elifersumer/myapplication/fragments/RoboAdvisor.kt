package com.elifersumer.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.elifersumer.myapplication.R

class RoboAdvisor : Fragment() {
    var navController: NavController? = null
    lateinit var risk_p: TextView
    lateinit var acklm: TextView
    lateinit var önri: TextView
    lateinit var devamke: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_robo_advisor, container, false)

        risk_p = view.findViewById(R.id.risk_p) as TextView
        acklm = view.findViewById(R.id.acklm) as TextView
        önri = view.findViewById(R.id.önri) as TextView
        devamke = view.findViewById(R.id.devamke) as Button


        val args = this.arguments
        val risk1Data = args?.get("risk1")
        val risk2Data = args?.get("risk2")
        val risk3Data = args?.get("risk3")
        val risk4Data = args?.get("risk4")
        val risk5Data = args?.get("risk5")
        val profile = args?.get("profile")


        var riskP: String = ""
        var acıklamaP : String = ""
        var sonuc: String = ""

        if(profile == "Muhafazakar"){
            riskP += "Muhafazakâr"
            acıklamaP += "Tamamladığınız anket sonucuna göre tahmini Risk/Getiri Profiliniz için önerilen KISTAS PORTFÖY Varlık Grubu Dağılımı aşağıdadır"
            sonuc += risk1Data.toString()
        }
        else if(profile == "Korumacı"){
            riskP += "Korumacı"
            acıklamaP += "Tamamladığınız anket sonucuna göre tahmini Risk/Getiri Profiliniz için önerilen KISTAS PORTFÖY Varlık Grubu Dağılımı aşağıdadır"
            sonuc += risk2Data.toString()
        }
        else if(profile == "Dengeli") {
            riskP += "Dengeli"
            acıklamaP += "Tamamladığınız anket sonucuna göre tahmini Risk/Getiri Profiliniz için önerilen KISTAS PORTFÖY Varlık Grubu Dağılımı aşağıdadır"
            sonuc = risk3Data.toString()

        }
        else if(profile == "RiskSever"){
            riskP += "RiskSever"
            acıklamaP += "Tamamladığınız anket sonucuna göre tahmini Risk/Getiri Profiliniz için önerilen KISTAS PORTFÖY Varlık Grubu Dağılımı aşağıdadır"
            sonuc = risk4Data.toString()
        }

        else if(profile == "Agresif"){
            riskP += "Agresif"
            acıklamaP += "Tamamladığınız anket sonucuna göre tahmini Risk/Getiri Profiliniz için önerilen KISTAS PORTFÖY Varlık Grubu Dağılımı aşağıdadır"
            sonuc = risk5Data.toString()
        }



        risk_p.text = riskP
        acklm.text = acıklamaP
        önri.text = sonuc

        devamke.setOnClickListener{

            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,DigerFragment())?.commit()
        }


        return view
    }
}