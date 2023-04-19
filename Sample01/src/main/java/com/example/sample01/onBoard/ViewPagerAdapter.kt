package com.example.sample01.onBoard

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sample01.R


class PagerAdapter(fragment: Fragment, context: Context) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = objectList.size

    private val objectList = listOf(
        OnBoardScreenParameter(
            context.getString(R.string.instant_payment), R.drawable.instantpaymentpg,
            context.getString(R.string.lorem)
        ),
        OnBoardScreenParameter(
            context.getString(R.string.cashback), R.drawable.cashbackpg,
            context.getString(R.string.lorem)
        ),
        OnBoardScreenParameter(
            context.getString(R.string.multiple_services), R.drawable.multipleservicepg,
            context.getString(R.string.lorem)
        )
    )

    override fun createFragment(position: Int): Fragment {
        return OnBoardFragment.newInstance(objectList[position])
    }

    data class OnBoardScreenParameter(
        val title: String,
        @DrawableRes val imageId: Int,
        val loremText: String
    )
}