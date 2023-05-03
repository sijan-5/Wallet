package com.generic.wallet.bankTransferFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentBankTransferFormBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BankTransferFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BankTransferFormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentBankTransferFormBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentBankTransferFormBinding.inflate(inflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_bankTransfer_to_transitionPin)
        }

        binding.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BankTransferFormFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BankTransferFormFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}