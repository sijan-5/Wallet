package com.generic.wallet.commondetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentCommonPaymentMethodBinding
import com.generic.wallet.electricityFeature.ElectricityPaymentMethodFragment
import com.generic.wallet.internetFeature.InternetPaymentMethodForm


/**
 * A simple [Fragment] subclass.
 * Use the [CommonPaymentMethodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

abstract class CommonPaymentMethodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: com.generic.wallet.databinding.FragmentCommonPaymentMethodBinding? = null
    private val binding get() = _binding!!
    abstract fun getPaymentItemsList(): List<PaymentDetailDataClass>
    abstract var getWalletBalance: String
    abstract var getPayableWalletBalance: String
    abstract var getTitleFromSubClass: String
    abstract fun getFragmentObject(): Fragment

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
        _binding = FragmentCommonPaymentMethodBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (getFragmentObject() is ElectricityPaymentMethodFragment) {
            setUpTitleAndBalance()
            setUpRecyclerView(getPaymentItemsList())

            binding.apply {
                linearLayout.visibility = View.GONE
                payInAdvanceCheckBox.visibility = View.VISIBLE
                payInAdvanceCheckBox.setOnCheckedChangeListener{_, isChecked ->
                    if (isChecked)
                    {
                        amountText.visibility = View.VISIBLE
                        amountEditText.visibility = View.VISIBLE
                    }
                    else
                    {
                        amountText.visibility = View.GONE
                        amountEditText.visibility = View.GONE
                    }
                }
            }
        }


        else if(getFragmentObject() is InternetPaymentMethodForm)
        {
            setUpTitleAndBalance()
            setUpRecyclerView(getPaymentItemsList())

            val inflater = LayoutInflater.from(activity)
            val hiddenViewForInternetPayment = inflater.inflate(R.layout.test,null,true)
            binding.apply {
                linearLayout.apply {
                    addView(hiddenViewForInternetPayment)
                    visibility = View.VISIBLE
                }
                amountEditText.visibility=View.GONE
                amountText.visibility= View.GONE
                payInAdvanceCheckBox.visibility = View.GONE
            }
        }

    }
    private fun setUpTitleAndBalance() {
        binding.apply {
            balance.text = getWalletBalance
            payableBalance.text = getPayableWalletBalance
            title.text = getTitleFromSubClass
            }
    }
    private fun setUpRecyclerView(paymentItem : List<PaymentDetailDataClass> )
    {
        binding.showPaymentDetailRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PaymentMethodAdapter(paymentItem)
        }
    }

}