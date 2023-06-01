package com.generic.wallet.sendMoneyFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.generic.wallet.databinding.FragmentBaseForDashboardBinding


abstract class BaseFragmentForDashboard : Fragment() {
    private var _binding: FragmentBaseForDashboardBinding? = null
    private val binding get() = _binding!!
    abstract fun getTitle(): String
    abstract fun getView(inflater: LayoutInflater): View?
    abstract fun goToPreviousFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBaseForDashboardBinding.inflate(inflater)
        val frameLayout = binding.frameLayout
        val title = binding.title
        title.text = getTitle()
        frameLayout.addView(getView(inflater))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrow.setOnClickListener {
            goToPreviousFragment()
        }
    }


}

