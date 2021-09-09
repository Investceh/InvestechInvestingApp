package com.elifersumer.myapplication

import android.annotation.SuppressLint
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.fragments.hisseler
import kotlinx.android.synthetic.main.rowlaout.*import kotlinx.android.synthetic.main.rowlaout.*


class RecyclerViewAdapter(var hisse_list : MutableList<hisseler>):

    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val tourName: TextView =view.findViewById(R.id.title_tv)
        val shrName: TextView =view.findViewById(R.id.exp_tv)
        val cost: TextView = view.findViewById(R.id.cost)
        val tane: TextView = view.findViewById(R.id.tane)
        val k_z: TextView = view.findViewById(R.id.k_z)
        val p_b : TextView = view.findViewById(R.id.expand_1_1)
        val but : Button = view.findViewById(R.id.button_id)
        val expandableView = view.findViewById<ViewGroup>(R.id.expandableView)

        fun initialize(item: hisseler)
        {
            shrName.text = item.sh_name
            cost.text = item.cost.toString()
            tane.text = item.tane.toString()
            k_z.text = item.k_z.toString()
            p_b.text = item.PotentialBenefit.toString()
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
                Toast.makeText(shrName.context,"Satıldı",Toast.LENGTH_SHORT)
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
        holder.shrName.text = hisse_list[position].sh_name
        holder.cost.text= hisse_list[position].cost.toString()
        holder.tane.text = hisse_list[position].tane.toString()
        holder.k_z.text = hisse_list[position].k_z.toString()
        holder.p_b.text = hisse_list[position].PotentialBenefit.toString()
        holder.initialize(hisse_list[position])
    }

    override fun getItemCount(): Int {
        return hisse_list.size
    }
}