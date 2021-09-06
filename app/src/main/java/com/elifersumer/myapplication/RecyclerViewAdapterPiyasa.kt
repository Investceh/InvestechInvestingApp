package com.elifersumer.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.fragments.hisseler

class RecyclerViewAdapterPiyasa(var hisse_list : ArrayList<PiyasaData>):
    RecyclerView.Adapter<RecyclerViewAdapterPiyasa.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val degisim=view.findViewById<TextView>(R.id.greendegisim)
        val isim=view.findViewById<TextView>(R.id.hisse_ismi)
        val alis=view.findViewById<TextView>(R.id.alis_fiyat)
        val satis=view.findViewById<TextView>(R.id.satis_fiyat)
        val fark=view.findViewById<TextView>(R.id.hisse_fark)
        val sat=view.findViewById<TextView>(R.id.sat_button)
        val al=view.findViewById<TextView>(R.id.al_button)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_piyasa,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.degisim.text=hisse_list[position].degisim
        holder.isim.text = hisse_list[position].hisse_ismi
        holder.alis.text = hisse_list[position].alis
        holder.satis.text = hisse_list[position].satis
        holder.fark.text = hisse_list[position].fark
        holder.sat.text = hisse_list[position].sat_button
        holder.al.text = hisse_list[position].al_button
    }

    override fun getItemCount(): Int {
        return hisse_list.size
    }

}

