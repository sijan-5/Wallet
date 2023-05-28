package com.generic.wallet.commondetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R


class PaymentMethodAdapter(val list : List<PaymentDetailDataClass>) : RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
       val view = LayoutInflater.from(parent.context).inflate(R.layout.payment_detail_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.infoType.text = item.informationType
        holder.actualInfo.text = item.actualInformation
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        val infoType : TextView = itemView.findViewById(R.id.informationType)
        val actualInfo : TextView = itemView.findViewById(R.id.actualInformation)
    }
}