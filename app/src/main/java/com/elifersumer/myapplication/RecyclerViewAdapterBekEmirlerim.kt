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

class RecyclerViewAdapterBekEmirlerim(var hisse_list: MutableList<BekleyenEmirlerimData>) :
    RecyclerView.Adapter<RecyclerViewAdapterBekEmirlerim.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val isim = view.findViewById<TextView>(R.id.BeHisse)
        val adet = view.findViewById<TextView>(R.id.BeAdet)
        val fiyat = view.findViewById<TextView>(R.id.BeFiyat)
        val alisOrSatis = view.findViewById<TextView>(R.id.BeAlisOrSatis)
        val iptal = view.findViewById<TextView>(R.id.Beİptal)
        val degis = view.findViewById<TextView>(R.id.BeDegis)

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

        }
        else{
            holder.isim.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.adet.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.fiyat.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.alisOrSatis.setBackgroundColor(Color.parseColor("#f5f5f5"))
        }
        if(hisse_list[position].alisOrsatis == "Alış"){
            holder.alisOrSatis.setTextColor(Color.GREEN)
        }
        else
            holder.alisOrSatis.setTextColor(Color.RED)

        holder.isim.text = hisse_list[position].hisse_ismi
        holder.adet.text = hisse_list[position].adet
        holder.fiyat.text = hisse_list[position].fiyat
        holder.alisOrSatis.text = hisse_list[position].alisOrsatis
        holder.iptal.text = hisse_list[position].iptal
        holder.degis.text = hisse_list[position].degis
    }


    override fun getItemCount(): Int {
        return hisse_list.size
    }

}

