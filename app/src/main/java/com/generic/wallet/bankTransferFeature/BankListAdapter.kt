package com.generic.wallet.bankTransferFeature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class BankListAdapter(
    val list: List<BankLogoAndNameDataClass>,
    private val onClickListener : () -> Unit
) : RecyclerView.Adapter<BankListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banklogo, parent, false)

        return ViewHolder(view).apply {

            this.itemV.setOnClickListener {
                onClickListener.invoke()
            }
        }
    }

    override fun onBindViewHolder(holder: BankListAdapter.ViewHolder, position: Int) {

            val item = list[position]
            holder.bankLogoImage.setImageResource(item.bankImageResource)
            holder.bankName.text = item.bankTextView
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val itemV: View) : RecyclerView.ViewHolder(itemV) {
        val bankLogoImage: ImageView = itemView.findViewById(R.id.bankLogo)
        val bankName: TextView = itemView.findViewById(R.id.bankName)

    }

}