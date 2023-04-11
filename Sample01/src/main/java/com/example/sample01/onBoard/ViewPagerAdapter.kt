package com.example.sample01.onBoard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return  when(position)
        {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }

    }
}