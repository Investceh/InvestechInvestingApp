package com.elifersumer.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.R
import com.elifersumer.myapplication.fragments.hisseler

class RecyclerViewAdapter(var hisse_list : ArrayList<hisseler>):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val tourName=view.findViewById<TextView>(R.id.title_tv)
        val photo=view.findViewById<ImageView>(R.id.imagev)
        val cost=view.findViewById<TextView>(R.id.cost)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rowlaout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tourName.text=hisse_list[position].name
        holder.photo.setImageResource(hisse_list[position].photo)
        holder.cost.text= hisse_list[position].cost
    }

    override fun getItemCount(): Int {
        return hisse_list.size
    }

}

