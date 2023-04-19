package com.example.sample01.onBoard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.setFragmentResult
import androidx.viewpager2.widget.ViewPager2
import com.example.sample01.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment() : Fragment() {

    private lateinit var pager :ViewPager2
    private lateinit var tabIndicator : TabLayout
    private lateinit var pagerAdapter : PagerAdapter
    private lateinit var nextButton : Button
    private lateinit var logInText : TextView
    private lateinit var skipText : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager = view.findViewById(R.id.pager)
        tabIndicator = view.findViewById(R.id.tabLayout)
        pagerAdapter = PagerAdapter(this, this.requireContext())
        nextButton = view.findViewById(R.id.nextButton)
        logInText = view.findViewById(R.id.logInText)
        skipText = view.findViewById(R.id.skipText)
        pager.adapter = pagerAdapter

        // connecting Tab_layout and viewpager
        TabLayoutMediator(tabIndicator, pager) { tab, positioin ->

        }.attach()


        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    logInText.visibility = View.VISIBLE
                    nextButton.text = "Create Account"
                    skipText.visibility = View.INVISIBLE
                } else {
                    logInText.visibility = View.INVISIBLE
                    skipText.visibility = View.VISIBLE
                    nextButton.text = "Next"
                }
                super.onPageSelected(position)
            }
        })
        nextButton.setOnClickListener {
            if(nextButton.text.equals("Create Account"))
            {
                requireActivity().setResult(Activity.RESULT_OK)
                requireActivity().finish()
            }
            else
            {
                pager.currentItem = pager.currentItem + 1
            }
        }
    }

}