package com.elifersumer.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.fragments.hisseler

class RecyclerViewAdapterIpEmirlerim(var hisse_list: MutableList<GeEmirlerimData>) :
    RecyclerView.Adapter<RecyclerViewAdapterIpEmirlerim.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val isim = view.findViewById<TextView>(R.id.IpHisse)
        val adet = view.findViewById<TextView>(R.id.IpAdet)
        val fiyat = view.findViewById<TextView>(R.id.IpFiyat)
        val alisOrSatis = view.findViewById<TextView>(R.id.IpAlisOrSatis)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout_iptal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position % 2  == 0){
            holder.isim.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.adet.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.fiyat.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.alisOrSatis.setBackgroundColor(Color.parseColor("#C7D3E1"))

        }
        holder.isim.text = hisse_list[position].hisse_ismi
        holder.adet.text = hisse_list[position].adet
        holder.fiyat.text = hisse_list[position].fiyat
        holder.alisOrSatis.text = hisse_list[position].alisOrsatis

        if(hisse_list[position].alisOrsatis == "Alış"){
            holder.alisOrSatis.setTextColor(Color.parseColor("#2D8326"))
        }
        else
            holder.alisOrSatis.setTextColor(Color.parseColor("#e2523e"))
    }


    override fun getItemCount(): Int {
        return hisse_list.size
    }

}

