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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InternetPaymentMethodForm.newInstance] factory method to
 * create an instance of this fragment.
 */

 class InternetPaymentMethodForm :CommonPaymentMethodFragment() {

    override fun getPaymentBillList(): List<PaymentDetailDataClass> {
        return listOf(PaymentDetailDataClass("UserName","Shooman"),
        PaymentDetailDataClass("Service Provider","WorldLink"),
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