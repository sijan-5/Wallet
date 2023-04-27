package com.generic.wallet.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class ReportAdapter(private val list:MutableList<DataClassForReport>) : RecyclerView.Adapter<ReportAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bank_statement_report,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.bankName.text = item.nameOfBank
        holder.phoneNumber.text =  item.phoneNumber
        holder.date.text = item.date
        holder.bankLogo.setImageResource(item.imageResource)
    }


    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val bankLogo: ImageView = itemView.findViewById(R.id.companyLogo)
        val bankName:TextView = itemView.findViewById(R.id.nameOfBank)
        val phoneNumber:TextView = itemView.findViewById(R.id.phoneNumber)
        val date :TextView = itemView.findViewById(R.id.date)
    }

}


