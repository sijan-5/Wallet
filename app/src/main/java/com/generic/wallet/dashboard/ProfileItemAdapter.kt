package com.generic.wallet.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R

class ProfileItemAdapter(
    private val profileItemList: List<ProfileItems>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val profileItems = 1
    private val divider = 2

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return when (viewType) {
            profileItems -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.profile_items, parent, false)
                return ProfileItemViewHolder(view)
            }

            divider -> {
                val divider = View(context)
                divider.layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    5
                ).apply {
                    setMargins(0, 50, 0, 0)
                }

                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.viewbackgroundcolor
                    )
                )
                return DividerViewHolder(divider)
            }

            else -> throw IllegalArgumentException("Invalid item type")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = profileItemList[position]

        when (item) {
            is ProfileItems.DataClassForProfileItems -> {

                val profileItemsHolder = holder as ProfileItemViewHolder
                profileItemsHolder.profileItemImage.setImageResource(item.imageResource)
                profileItemsHolder.profileItemName.text = item.serviceName
                profileItemsHolder.profileItemImage.setBackgroundResource(R.drawable.fill_kyc_background)
                profileItemsHolder.profileItemImage.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        item.backgroundColorId
                    ))

                holder.overflowArrow.setOnClickListener {
                    holder.childItems.visibility = View.VISIBLE
                    holder.overflowArrow.setImageResource(R.drawable.hide_child_items)
                }

            }
            ProfileItems.Divider -> {

            }


        }
    }


//        when (holder.itemViewType) {
//            profileItems -> {
//                val profileItemsHolder = holder as ProfileItemViewHolder
//                profileItemsHolder.profileItemImage.setImageResource(item.imageResource)
//                profileItemsHolder.profileItemName.text = item.serviceName
//                profileItemsHolder.profileItemImage.setBackgroundResource(R.drawable.fill_kyc_background)
//                profileItemsHolder.profileItemImage.setBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        item.backgroundColorId
//                    )
//
//            }
//        }


    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)

        return when (profileItemList[position]) {
            is ProfileItems.DataClassForProfileItems -> profileItems

            is ProfileItems.Divider -> divider
        }
    }


    override fun getItemCount(): Int = profileItemList.size


    class ProfileItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val profileItemImage: ImageView = itemView.findViewById(R.id.profileItemImage)
        val profileItemName: TextView = itemView.findViewById(R.id.profileItemName)
        val childItems : LinearLayout = itemView.findViewById(R.id.childItems)
        val overflowArrow : ImageView = itemView.findViewById(R.id.overflowArrow)
    }

    class DividerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}