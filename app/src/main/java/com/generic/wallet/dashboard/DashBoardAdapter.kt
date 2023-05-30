package com.generic.wallet.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class DashBoardAdapter(val list: List<DashBoardItemDataClass>) :
    RecyclerView.Adapter<DashBoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dash_board_item_layout, parent, false)

        return ViewHolder(view).apply {
            dashBoardItemView.setOnClickListener {
                val position = list[adapterPosition]
                position.clickedItem.invoke()

            }
        }
    }

    override fun onBindViewHolder(holder: DashBoardAdapter.ViewHolder, position: Int) {

        val item = list[position]
        holder.logoName.text = item.logoName

        holder.logoImage.apply {
            setImageResource(item.imageResource)
            setBackgroundResource(item.backGroundResource)
        }


    }

    override fun getItemCount(): Int = list.size


    class ViewHolder(val dashBoardItemView: View) : RecyclerView.ViewHolder(dashBoardItemView) {
        val logoImage: ImageView = dashBoardItemView.findViewById(R.id.dashboardItemLogo)
        val logoName: TextView = dashBoardItemView.findViewById(R.id.dashBoardItemName)
    }


}