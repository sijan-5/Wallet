package com.generic.wallet.waterFeature

import android.view.View
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.commondetail.CommonPaymentMethodFragment
import com.generic.wallet.commondetail.PaymentDetailDataClass


class WaterPaymentMethod : CommonPaymentMethodFragment() {
    // TODO: Rename and change types of parameters
    override fun getPaymentBillList(): List<PaymentDetailDataClass> {
           return  listOf(
                PaymentDetailDataClass("Service", arguments?.getString(WATER_BOARD_TITLE_KEY).toString()),
                PaymentDetailDataClass("Counter", arguments?.getString(WATER_COUNTER_KEY).toString()),
                PaymentDetailDataClass("Customer ID",arguments?.getString(WATER_CUSTOMER_ID_KEY).toString()),
                PaymentDetailDataClass("Water Meter", "**"),
                PaymentDetailDataClass("Total Cost", "##"),
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

}