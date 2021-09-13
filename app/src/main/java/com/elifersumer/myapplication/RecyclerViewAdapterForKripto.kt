package com.elifersumer.myapplication

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.elifersumer.myapplication.fragments.EmirFragment
import org.greenrobot.eventbus.EventBus

class RecyclerViewAdapterForKripto(var hisse_list: MutableList<PiyasaData>) :
    RecyclerView.Adapter<RecyclerViewAdapterForKripto.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val degisim = view.findViewById<ImageView>(R.id.greendegisim)
        val isim = view.findViewById<TextView>(R.id.hisse_ismi)
        val alis = view.findViewById<TextView>(R.id.alis_fiyat)
        val satis = view.findViewById<TextView>(R.id.satis_fiyat)
        val fark = view.findViewById<TextView>(R.id.hisse_fark)
        val sat = view.findViewById<Button>(R.id.sat_button)
        val al = view.findViewById<Button>(R.id.al_button)


        fun initialize(item:PiyasaData) {
            var satisOrAlis = ""
            isim.text = item.hisse_ismi
            al.setOnClickListener{
                val isimString:String = isim.text.toString()
                val satisString:String = satis.text.toString()
                val alisString:String = alis.text.toString()
                val farkString:String = fark.text.toString()
                satisOrAlis ="alis"
                val bundle = Bundle()
                bundle.putString("satis",satisString)
                bundle.putString("isim",isimString)
                bundle.putString("alis",alisString)
                bundle.putString("alisOrSatis",satisOrAlis)
                bundle.putString("fark",farkString)
                val fragment = EmirFragment()
                fragment.arguments = bundle
                val manager: FragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                manager.beginTransaction()?.replace(R.id.fragmentContainerView,fragment).commit()
                Toast.makeText(isim.context,"Alındı",Toast.LENGTH_SHORT).show()
            }
            sat.setOnClickListener{
                val isimString:String = isim.text.toString()
                val satisString:String = satis.text.toString()
                val alisString:String = alis.text.toString()
                val farkString:String = fark.text.toString()
                satisOrAlis = "satis"
                val bundle = Bundle()
                bundle.putString("satis",satisString)
                bundle.putString("isim",isimString)
                bundle.putString("alis",alisString)
                bundle.putString("alisOrSatis",satisOrAlis)
                bundle.putString("fark",farkString)
                val fragment = EmirFragment()
                fragment.arguments = bundle
                val manager: FragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                manager.beginTransaction()?.replace(R.id.fragmentContainerView,fragment).commit()
                Toast.makeText(isim.context,"Satıldı",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout_piyasa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position % 2 == 0){
            holder.degisim.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.isim.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.alis.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.satis.setBackgroundColor(Color.parseColor("#C7D3E1"))
            holder.fark.setBackgroundColor(Color.parseColor("#C7D3E1"))
        }
        else{
            holder.degisim.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.isim.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.alis.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.satis.setBackgroundColor(Color.parseColor("#f5f5f5"))
            holder.fark.setBackgroundColor(Color.parseColor("#f5f5f5"))
        }
        if (hisse_list[position].fark.toFloat() >= 0.00) {
            holder.fark.text = "+" +  hisse_list[position].fark + "%"
            holder.fark.setTextColor(Color.GREEN)
            holder.degisim.setImageResource(R.drawable.ic_rise_up_green)
        } else {
            holder.fark.text =hisse_list[position].fark + "%"
            holder.fark.setTextColor(Color.RED)
            holder.degisim.setImageResource(R.drawable.ic_rise_up_red)
        }
        holder.isim.text = hisse_list[position].hisse_ismi
        holder.alis.text = hisse_list[position].alis
        holder.satis.text = hisse_list[position].satis

        holder.initialize(hisse_list[position])
    }


    override fun getItemCount(): Int {
        return hisse_list.size
    }


}

