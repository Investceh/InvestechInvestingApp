package com.elifersumer.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.Database.CanceledOrder
import com.elifersumer.myapplication.Database.Helper.DbHelper
import com.elifersumer.myapplication.Database.Managers.CanceledDbManager
import com.elifersumer.myapplication.Database.Managers.WaitingDbManager
import com.elifersumer.myapplication.Database.WaitingOrder
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.fragments.BekleyenEmirFragment
import com.elifersumer.myapplication.fragments.hisseler

class RecyclerViewAdapterBekEmirlerim(var hisse_list: MutableList<WaitingOrder>) :
    RecyclerView.Adapter<RecyclerViewAdapterBekEmirlerim.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var navController: NavController? = null
        val db by lazy { DbHelper(view.context) }
        val isim = view.findViewById<TextView>(R.id.BeHisse)
        val adet = view.findViewById<TextView>(R.id.BeAdet)
        val fiyat = view.findViewById<TextView>(R.id.BeFiyat)
        val alisOrSatis = view.findViewById<TextView>(R.id.BeAlisOrSatis)
        val iptal = view.findViewById<View>(R.id.iptalBG)
        val degis = view.findViewById<View>(R.id.degisimBG)
        val iptalButton = view.findViewById<ImageButton>(R.id.buttonIptal)
        val degisButton = view.findViewById<ImageButton>(R.id.buttonDegisim)
        fun initialize(item:WaitingOrder) {
            iptalButton.setOnClickListener {
                var waitingDbManager = WaitingDbManager(iptalButton.context,db.writableDatabase)
                var canceledOrder = CanceledOrder(item.Hisse!!,item.Adet!!,item.Fiyat!!,item.IslemTipi!!)
                var canceledDbManager= CanceledDbManager(iptalButton.context,db.writableDatabase)
                canceledDbManager.insertData(canceledOrder)
                waitingDbManager.deletDataByName(item.Hisse.toString())
                navController = Navigation.findNavController(itemView)
                navController!!.navigate(R.id.action_blankFragment_self)
                Toast.makeText(isim.context,"İptal", Toast.LENGTH_SHORT).show()
            }
            degisButton.setOnClickListener {

                Toast.makeText(isim.context,"Degis", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout_bekleyen, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position % 2  == 0){
            holder.isim.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.adet.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.fiyat.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.alisOrSatis.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.degis.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.iptal.setBackgroundColor(Color.parseColor("#C7D3E1"))

        }
        else{
            holder.isim.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.adet.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.fiyat.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.alisOrSatis.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.degis.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.iptal.setBackgroundColor(Color.parseColor("#f5f5f5"))
        }
        if(hisse_list[position].IslemTipi == "Alış"){
            holder.alisOrSatis.setTextColor(Color.parseColor("#2D8326"))
        }
        else
            holder.alisOrSatis.setTextColor(Color.parseColor("#e2523e"))

        holder.isim.text = hisse_list[position].Hisse
        holder.adet.text = hisse_list[position].Adet
        holder.fiyat.text = hisse_list[position].Fiyat
        holder.alisOrSatis.text = hisse_list[position].IslemTipi
        holder.initialize(hisse_list[position])
    }


    override fun getItemCount(): Int {
        return hisse_list.size
    }

}

