package com.generic.wallet.electricityFeature

import android.os.Bundle
import androidx.fragment.app.Fragment

import com.generic.wallet.commondetail.CommonPaymentMethodFragment
import com.generic.wallet.commondetail.PaymentDetailDataClass


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ElectricityPaymentMethodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ElectricityPaymentMethodFragment(
) : CommonPaymentMethodFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    private var _binding :FragmentELectricityPaymentMethodBinding? = null
//    private val binding get() = _binding!!
    override fun getPaymentItemsList() : List<PaymentDetailDataClass> {
        return listOf(
            PaymentDetailDataClass("Service","NEA"),
            PaymentDetailDataClass("Counter","Satungal"),
            PaymentDetailDataClass("SC Number", "948.##.####"),
            PaymentDetailDataClass("Customer ID", "******"),
            PaymentDetailDataClass("Total Amount","NPR ####"),
            PaymentDetailDataClass("Previous Dues","NPR ####"),
            PaymentDetailDataClass("Dues Date Form","YYYY/MM/DD"),
        )
    }

    override fun getFragmentObject(): Fragment {
        return this
    }

    override var getWalletBalance: String = "NPR ####"
    override var getPayableWalletBalance: String = "NPR ####"
    override var getTitleFromSubClass: String = "Electricity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        _binding = FragmentELectricityPaymentMethodBinding.inflate(inflater)
//        return binding.root
////    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.backArrow.setOnClickListener {
//            findNavController().popBackStack()
//        }
//
//        binding.payButton.setOnClickListener {
//            findNavController().navigate(R.id.action_electricity_to_transitionPin)
//        }
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ELectricityPaymentMethodFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ElectricityPaymentMethodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}