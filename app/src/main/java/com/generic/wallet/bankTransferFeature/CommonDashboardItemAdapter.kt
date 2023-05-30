package com.generic.wallet.bankTransferFeature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class CommonDashboardItemAdapter(
    val list: List<CommonUtilitiesDataClass>,
    private val onClickListener : (String) -> Unit
) : RecyclerView.Adapter<CommonDashboardItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banklogo, parent, false)
        val viewHolder = ViewHolder(view)


        viewHolder.itemV.setOnClickListener {

            val position = viewHolder.adapterPosition
            val item = list[position]
            onClickListener.invoke(item.itemName)

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val item = list[position]
            holder.bankLogoImage.setImageResource(item.bankImageResource)
            holder.bankName.text = item.itemName
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val itemV: View) : RecyclerView.ViewHolder(itemV) {
        val bankLogoImage: ImageView = itemV.findViewById(R.id.bankLogo)
        val bankName: TextView = itemV.findViewById(R.id.bankName)

    }

}