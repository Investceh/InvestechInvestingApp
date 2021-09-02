package com.elifersumer.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class MyAdapter(private val hisseler: ArrayList<hisseler>) : Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.items)
        val heading : TextView = itemView.findViewById(R.id.view_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = hisseler[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.heading

    }

    override fun getItemCount(): Int {
        return hisseler.size
    }

}