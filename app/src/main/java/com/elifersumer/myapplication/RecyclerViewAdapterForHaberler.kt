package com.elifersumer.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.DecimalFormat


class RecyclerViewAdapterForHaberler(var haberler_list : MutableList<haberler>):

    RecyclerView.Adapter<RecyclerViewAdapterForHaberler.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val baslik: TextView =view.findViewById(R.id.baslik)
        val aciklama: TextView = view.findViewById(R.id.aciklama)
        val kaynak: TextView = view.findViewById(R.id.kaynak)
        val devam: Button = view.findViewById(R.id.dvmBtn)
        val imageView:ImageView=view.findViewById(R.id.haberimage)
        val haber_animation = view.findViewById<CardView>(R.id.cardview)

    //    val image: ImageView=view.findViewById(R.id.haberimage)

        val expandableView = view.findViewById<ViewGroup>(R.id.expandableView2)
   //     var bmp : Bitmap ?=null

        val df = DecimalFormat("#,##0.00")

        fun initialize(item: haberler)
        {
            baslik.text=item.baslik
            aciklama.text=item.aciklama
            kaynak.text=item.kaynak
            Glide.with(imageView.context).load(item.imgUrl).into(imageView)
/*
            bmp=item.bmp
            image.setImageBitmap(bmp)
*/

            devam.setOnClickListener{
                var link = Uri.parse(item.linkUrl)
                var intent = Intent(Intent.ACTION_VIEW,link)
                var bundle = Bundle()
                startActivity(devam.context,intent,bundle)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapterForHaberler.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_haberler,parent,false)
        return RecyclerViewAdapterForHaberler.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapterForHaberler.ViewHolder, position: Int) {
        holder.baslik.text = haberler_list[position].baslik
        holder.aciklama.text= haberler_list[position].aciklama
        holder.kaynak.text = haberler_list[position].kaynak
        var uri:String=haberler_list[position].imgUrl
        Glide.with(holder.imageView.getContext()).load(uri).into(holder.imageView)
        holder.haber_animation.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.haber_rv_anim)
        holder.initialize(haberler_list[position])
    }

    override fun getItemCount(): Int {
        return haberler_list.size
    }


}