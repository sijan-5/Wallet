package com.generic.wallet.loadWalletFeature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class LoadWalletAdapter(val list : List<LoadWalletDataClass>, val lam:() ->Unit) : RecyclerView.Adapter<LoadWalletAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LoadWalletAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.banklogo,parent,false)
        return ViewHolder(view).apply {

            loadWalletView.setOnClickListener {
                val item = list[adapterPosition]
                item.onClickListener.invoke()
            }
        }
    }

    override fun onBindViewHolder(holder: LoadWalletAdapter.ViewHolder, position: Int) {
        val item = list[position]

        holder.bankLogoImage.setImageResource(item.imageResource)
        holder.bankName.text = item.imageViewName
    }

    override fun getItemCount(): Int = list.size


    class ViewHolder(val loadWalletView : View) : RecyclerView.ViewHolder(loadWalletView)
    {
        val bankLogoImage: ImageView = itemView.findViewById(R.id.bankLogo)
        val bankName: TextView = itemView.findViewById(R.id.bankName)
    }


}