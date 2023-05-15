package com.generic.wallet.dashboard_third

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R
import com.generic.wallet.bankTransferFeature.BankLogoAndNameDataClass
import com.generic.wallet.dashboard_one.DashboardOneDataClass

class AdapterThirdRecentPayments(val list: List<BankLogoAndNameDataClass>) : RecyclerView.Adapter<AdapterThirdRecentPayments.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_payments_bg,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =  list[position]
        holder.itemLogo.setImageResource(item.bankImageResource)
        holder.itemName.text = item.bankTextView

    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val itemLogo : ImageView = itemView.findViewById(R.id.bankLogo)
        val itemName : TextView =  itemView.findViewById(R.id.bankName)
    }
}

