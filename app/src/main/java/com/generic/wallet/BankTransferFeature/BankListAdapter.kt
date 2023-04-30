package com.generic.wallet.BankTransferFeature

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class BankListAdapter(val list : List<BankLogoAndNameDataClass>, private val  istener : MyInterface ) : RecyclerView.Adapter<BankListAdapter.ViewHolder> () {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banklogo,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BankListAdapter.ViewHolder, position: Int) {

        val item = list[position]
        holder.bankLogoImage.setImageResource(item.bankImageResource)
        holder.bankName.text = item.bankTextView
        holder.itemView.setOnClickListener {

            istener.changeFragment()
        }
    }

    override fun getItemCount(): Int  = list.size

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {

        val bankLogoImage : ImageView = itemView.findViewById(R.id.bankLogo)
        val bankName : TextView = itemView.findViewById(R.id.bankName)

    }


    interface MyInterface
    {

        fun changeFragment()
    }

}