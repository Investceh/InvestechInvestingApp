package com.elifersumer.myapplication

import android.annotation.SuppressLint
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.fragments.hisseler
import kotlinx.android.synthetic.main.rowlaout.*import kotlinx.android.synthetic.main.rowlaout.*
import java.text.DecimalFormat


class RecyclerViewAdapter(var hisse_list : MutableList<hisseler>):

    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val sh_name: TextView =view.findViewById(R.id.title_tv)
        val cost: TextView = view.findViewById(R.id.cost)
        val tane: TextView = view.findViewById(R.id.tane)
        val k_z: TextView = view.findViewById(R.id.k_z)
        val p_b : TextView = view.findViewById(R.id.expand_1_1)
        val but : Button = view.findViewById(R.id.button_id)
        //val rate : TextView = view.findViewById(R.id.expand_3_1)
        val price : TextView = view.findViewById(R.id.price)
        //val stockItem : TextView = view.findViewById(R.id.expand_4_1)
        val expandableView = view.findViewById<ViewGroup>(R.id.expandableView)
        val cv_animation = view.findViewById<CardView>(R.id.cardview)



        val df = DecimalFormat("#,##0.00")

        fun initialize(item: hisseler)
        {
            val df = DecimalFormat("#,##0.00")
            sh_name.text = item.sh_name

            val kost = df.format(item.cost).replace(',','.').reversed().replaceFirst('.',',').reversed()
            cost.text = kost // bu ALIS FİYATI YAZDIGIMIZ YER

            val adet = df.format(item.tane).replace(',','.').reversed().replaceFirst('.',',').reversed()
            tane.text = adet

            val ka_ze = df.format(item.k_z).replace(',','.').reversed().replaceFirst('.',',').reversed()
            k_z.text =  ka_ze

            val pot_b = df.format(item.PotentialBenefit).replace(',','.').reversed().replaceFirst('.',',').reversed()
            p_b.text = pot_b


            val fiyat = df.format(item.price).replace(',','.').reversed().replaceFirst('.',',').reversed()
            price.text = fiyat

            //stockItem.text = item.stockItem.toString()


            itemView.setOnClickListener{
                if(expandableView.visibility == View.GONE){
                    TransitionManager.beginDelayedTransition(expandableView, AutoTransition())
                    expandableView.visibility = View.VISIBLE
                }
                else{
                    TransitionManager.beginDelayedTransition(expandableView, AutoTransition())
                    expandableView.visibility = View.GONE
                }
            }
            but.setOnClickListener{
                Toast.makeText(sh_name.context,"Satıldı",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rowlaout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val df = DecimalFormat("#,##0.00")

        holder.sh_name.text = hisse_list[position].sh_name
        holder.cost.text= hisse_list[position].cost.toString()
        holder.tane.text = hisse_list[position].tane.toString()
        holder.k_z.text = hisse_list[position].k_z.toString()
        holder.p_b.text = hisse_list[position].PotentialBenefit.toString()
        //holder.rate.text = hisse_list[position].rate.toString()
        holder.price.text = hisse_list[position].price.toString()
        //holder.stockItem.text = hisse_list[position].stockItem.toString()
        holder.cv_animation.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.rv_anim)
        holder.initialize(hisse_list[position])


    }

    override fun getItemCount(): Int {
        return hisse_list.size
    }
}