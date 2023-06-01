package com.generic.wallet.sendMoneyFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewPropertyAnimator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentSendMoneyFormBinding


class SendMoneyFormFragment : BaseFragmentForDashboard() {
    private var _binding: FragmentSendMoneyFormBinding? = null
    private val binding get() = _binding!!

    override fun getTitle(): String {
        return resources.getString(R.string.send_money)
    }

    override fun goToPreviousFragment() {
      findNavController().popBackStack()
    }

    override fun getView(inflater: LayoutInflater): View {
        _binding =  FragmentSendMoneyFormBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_sendMoneyForm_to_sendMoneyPaymentMethod)
        }
    }

}