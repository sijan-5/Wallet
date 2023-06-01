package com.generic.wallet.electricityFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R

import com.generic.wallet.commondetail.CommonPaymentMethodFragment
import com.generic.wallet.commondetail.PaymentDetailDataClass
import com.google.android.material.textfield.TextInputLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ElectricityPaymentMethodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ElectricityPaymentMethodFragment() : CommonPaymentMethodFragment() {

    override var getWalletBalance: String = "NPR ####"
    override var getPayableWalletBalance: String = "NPR ####"
    override fun getTitleFromSubClass(): String = resources.getString(R.string.electricity)


    override fun getPaymentBillList(): List<PaymentDetailDataClass> {

           return listOf(
                    PaymentDetailDataClass("Service", "NEA"),
                    PaymentDetailDataClass("Counter", arguments?.getString(COUNTERLOCATIONKEY)!!),
                    PaymentDetailDataClass("SC Number", arguments?.getString(SCNUMBERKEY)!!),
                    PaymentDetailDataClass("Customer ID", arguments?.getString(CUSTOMERIDKEY)!!),
                    PaymentDetailDataClass("Total Amount", "NPR ####"),
                    PaymentDetailDataClass("Previous Dues", "NPR ####"),
                    PaymentDetailDataClass("Dues Date Form", "YYYY/MM/DD"),
            )
    }


    override fun getChildView(): View {
        val inflater = LayoutInflater.from(activity)
        return inflater.inflate(R.layout.fragment_electricity_payment_method, null, false)
    }

    override fun navigateBack() {
        findNavController().popBackStack()
    }

    override fun navigateToConfirmation() {
        findNavController().navigate(R.id.action_electricity_to_transitionPin)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CheckBox>(R.id.payInAdvanceCheckBox)
            .setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    view.findViewById<TextView>(R.id.amountText).visibility = View.VISIBLE
                    view.findViewById<TextInputLayout>(R.id.amountEditText).visibility =
                        View.VISIBLE
                } else {
                    view.findViewById<TextView>(R.id.amountText).visibility = View.GONE
                    view.findViewById<TextInputLayout>(R.id.amountEditText).visibility =
                        View.GONE
                }
            }


    }


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
        fun newInstance(param1: String, param2: String) = ElectricityPaymentMethodFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}