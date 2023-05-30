package com.generic.wallet.waterFeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.commondetail.CommonPaymentMethodFragment
import com.generic.wallet.commondetail.PaymentDetailDataClass

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WaterPaymentMethod.newInstance] factory method to
 * create an instance of this fragment.
 */
class WaterPaymentMethod : CommonPaymentMethodFragment() {
    // TODO: Rename and change types of parameters

    override fun getPaymentBillList(): List<PaymentDetailDataClass> {
        return listOf(
            PaymentDetailDataClass("Service","NWSC"),
            PaymentDetailDataClass("Counter","Kathmandu"),
            PaymentDetailDataClass("Counter ID","*****"),
            PaymentDetailDataClass("Water Meter","**"),
            PaymentDetailDataClass("Total Cost","##"),
        )
    }

    override var getWalletBalance: String = "NPR 123"
    override var getPayableWalletBalance: String = "NPR 123"
    override fun getTitleFromSubClass(): String = resources.getString(R.string.water)

    override fun getChildView(): View? {
        return null
    }



    override fun navigateToConfirmation() {
        findNavController().navigate(R.id.action_waterPayment_to_transactionPin)
    }

    override fun navigateBack() {
        findNavController().popBackStack()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WaterPaymentMethod.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WaterPaymentMethod().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}