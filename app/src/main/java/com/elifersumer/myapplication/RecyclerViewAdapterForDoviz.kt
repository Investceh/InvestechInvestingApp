package com.elifersumer.myapplication

import android.graphics.Color
import android.text.Editable
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import org.greenrobot.eventbus.EventBus

class RecyclerViewAdapterForDoviz(var hisse_list: MutableList<PiyasaData>) :
    RecyclerView.Adapter<RecyclerViewAdapterForDoviz.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val degisim = view.findViewById<ImageView>(R.id.greendegisim)
        val isim = view.findViewById<TextView>(R.id.hisse_ismi_dov)
        val alis = view.findViewById<TextView>(R.id.alis_fiyat_dov)
        val satis = view.findViewById<TextView>(R.id.satis_fiyat_dov)
        val fark = view.findViewById<TextView>(R.id.hisse_fark_dov)
        val sat = view.findViewById<Button>(R.id.sat_button_dov)
        val al = view.findViewById<Button>(R.id.al_button_dov)
        fun initialize(item:PiyasaData) {
            isim.text = item.hisse_ismi
            al.setOnClickListener{
                Toast.makeText(isim.context,"Alındı",Toast.LENGTH_SHORT).show()
            }
            sat.setOnClickListener{
                val messageString:String = satis.toString()
                val newMessageToSend:MessageEvent = MessageEvent(messageString)
                EventBus.getDefault().post(newMessageToSend)
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

    override fun getItemCount(): Int {
        return hisse_list.size
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


}

