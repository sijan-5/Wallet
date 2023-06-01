package com.generic.wallet.authfragments


import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginStart
import androidx.fragment.app.Fragment
import com.generic.wallet.R


abstract class FragmentWithTitleBar : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    abstract fun provideView(inflater: LayoutInflater): View
    abstract fun getTitle(): String
    abstract fun goToPreviousFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val verticalLinearLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16,42,0,0)
        }

        //base fragment toolbar
        val toolBarHorizontalLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(16,0,0,0)
            gravity = Gravity.CENTER_VERTICAL
        }

        //title  textView
        val textView = TextView(requireContext()).apply {
            text = getTitle()
            textSize = 20f
            typeface = ResourcesCompat.getFont(requireContext(), R.font.quicksand_bold)
            setTextColor(ContextCompat.getColor(requireContext(), com.example.sample01.R.color.bold_text_color))
        }
        //back arrow  View
        val imageView = ImageView(requireContext()).apply {
            setImageResource(com.example.sample01.R.drawable.arrow_back)
                setOnClickListener {
                    goToPreviousFragment()
                }
        }

        toolBarHorizontalLayout.addView(
            imageView, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        toolBarHorizontalLayout.addView(textView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            this.marginStart = 16
        })

        //fragment container
        val frameLayoutView = FrameLayout(requireContext())
        frameLayoutView.addView(provideView(inflater))
        verticalLinearLayout.addView(toolBarHorizontalLayout)
        verticalLinearLayout.addView(frameLayoutView)

        return ScrollView(requireContext()).apply {
            addView(verticalLinearLayout)
        }

    }
}

