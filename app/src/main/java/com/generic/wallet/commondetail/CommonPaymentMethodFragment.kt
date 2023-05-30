package com.generic.wallet.commondetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.generic.wallet.databinding.FragmentCommonPaymentMethodBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CommonPaymentMethodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
const val TAG = "TAG"
abstract class CommonPaymentMethodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentCommonPaymentMethodBinding? = null
    private  val binding get() = _binding!!
    abstract fun getPaymentBillList(): List<PaymentDetailDataClass>
    abstract var getWalletBalance: String
    abstract var getPayableWalletBalance: String
    abstract fun getTitleFromSubClass() : String
    abstract fun getChildView() : View?
    abstract fun navigateToConfirmation()
    abstract fun navigateBack()
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

        getChildView()?.let {
            binding.container.addView(it)
        }

        binding.apply {
           backArrow.setOnClickListener {
               navigateBack()
           }
            payButton.setOnClickListener {
                navigateToConfirmation()
            }
        }
        setUpTitleAndBalance()
        setUpRecyclerView()
    }
    private fun setUpTitleAndBalance() {
        binding.apply {
            balance.text = getWalletBalance
            payableBalance.text = getPayableWalletBalance
            title.text = getTitleFromSubClass()
            }
    }
    private fun setUpRecyclerView()
    {
        binding.showPaymentDetailRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PaymentMethodAdapter(getPaymentBillList())
        }
    }

}