package com.generic.wallet.dashboard_third

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R
import com.generic.wallet.dashboard_one.DashboardOneDataClass


class AdapterThirdServices(val list: List<DashboardOneDataClass>) : RecyclerView.Adapter<AdapterThirdServices.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_third_service_bg_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =  list[position]
        holder.itemLogo.setImageResource(item.imageResource)
        holder.itemName.text = item.logoName
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {

        val itemLogo : ImageView = itemView.findViewById(R.id.itemLogo)
        val itemName : TextView =  itemView.findViewById(R.id.itemText)

    }

}