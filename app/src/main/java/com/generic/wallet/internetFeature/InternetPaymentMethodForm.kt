package com.generic.wallet.internetFeature

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.SelectTitle
import com.generic.wallet.commondetail.CommonPaymentMethodFragment
import com.generic.wallet.commondetail.PaymentDetailDataClass
import com.generic.wallet.databinding.FragmentInternetPaymentMethodFormBinding

 class InternetPaymentMethodForm :CommonPaymentMethodFragment() {

    override fun getPaymentBillList(): List<PaymentDetailDataClass> {
        return listOf(PaymentDetailDataClass("UserName",arguments?.getString(INTERNET_USERNAME).toString()),
        PaymentDetailDataClass("Service Provider",arguments?.getString(INTERNET_TITLE).toString()),
        PaymentDetailDataClass("Status","Active"),
        PaymentDetailDataClass("Selected Plan","500Mb/Mth"))
    }


    override var getWalletBalance: String = "NPR 123"
    override var getPayableWalletBalance: String = "NPR 123"

    override fun getTitleFromSubClass() : String = resources.getString(R.string.internet)


    override fun getChildView(): View {
        val inflater = LayoutInflater.from(activity)
        return inflater.inflate(R.layout.fragment_internet_payment_method_form, null ,false)
    }


    override fun navigateToConfirmation() {
        findNavController().navigate(R.id.action_internet_to_transitionPin)
    }

    override fun navigateBack() {
        findNavController().popBackStack()
    }



}