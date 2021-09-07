package com.elifersumer.myapplication

import android.annotation.SuppressLint
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.fragments.hisseler
import kotlinx.android.synthetic.main.rowlaout.*import kotlinx.android.synthetic.main.rowlaout.*


class RecyclerViewAdapter(var hisse_list : ArrayList<hisseler>):

    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val tourName: TextView =view.findViewById<TextView>(R.id.title_tv)
        val shrName: TextView =view.findViewById<TextView>(R.id.exp_tv)
        val photo: ImageView =view.findViewById<ImageView>(R.id.imagev)
        val cost: TextView = view.findViewById(R.id.cost)
        val expandableView = view.findViewById<ViewGroup>(R.id.expandableView)

        fun initialize(item: hisseler)
        {
            tourName.text = item.name
            shrName.text = item.sh_name
            cost.text = item.cost
            photo.setImageResource(item.photo)
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
        holder.tourName.text=hisse_list[position].name
        holder.shrName.text = hisse_list[position].sh_name
        holder.photo.setImageResource(hisse_list[position].photo)
        holder.cost.text= hisse_list[position].cost
        holder.initialize(hisse_list[position])
    }

    override fun getItemCount(): Int {
        return hisse_list.size
    }
}