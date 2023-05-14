package com.generic.wallet.dashboard_one

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class DashboardOneAdapter(
    private val listOfItems: List<DashboardOneDataClass>,
    private val cashBackText:String = "Your cash back is 5%",
) : RecyclerView.Adapter<DashboardOneAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DashboardOneAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_one_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardOneAdapter.ViewHolder, position: Int) {

        val item = listOfItems[position]
        holder.itemImage.setImageResource(item.imageResource)
        holder.itemImage.setBackgroundResource(item.imageResource_bg_drawable)
        holder.itemName.text = item.logoName

        if(item.cashBackBoolean)
        {
            holder.cashBack.text = cashBackText
            holder.cashBack.visibility = View.VISIBLE
        }
        else{
            holder.cashBack.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = listOfItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById<ImageView>(R.id.dashboardItemLogo)
        val itemName: TextView = itemView.findViewById(R.id.dashBoardItemName)
        val cashBack :TextView = itemView.findViewById(R.id.cashBackText)
    }

}