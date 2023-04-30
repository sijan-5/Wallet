package com.generic.wallet.sendmoneyfreature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentSendMoneyPaymentMethodBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SendMoneyPaymentMethodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SendMoneyPaymentMethodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentSendMoneyPaymentMethodBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSendMoneyPaymentMethodBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.continueButton?.setOnClickListener {
            findNavController().navigate(R.id.action_sendMoneyPaymentMethod_to_sendMoneyTransistionPinFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SendMoneyPaymentMethod.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SendMoneyPaymentMethodFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}