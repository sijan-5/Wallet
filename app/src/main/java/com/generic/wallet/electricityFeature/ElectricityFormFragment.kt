package com.generic.wallet.electricityFeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.dashboard.titleNameKey
import com.generic.wallet.databinding.FragmentElectricityFormBinding


const val SCNUMBERKEY: String = "ScNumber"
const val CUSTOMERIDKEY: String = "CustomerID"
const val COUNTERLOCATIONKEY: String = "CounterLocation"

class ElectricityFormFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentElectricityFormBinding? = null
    private val binding get() = _binding!!
    lateinit var counterLocation: String
    private lateinit var adapter: ArrayAdapter<CharSequence>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentElectricityFormBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSpinnerAdapter()

        arguments?.let {
            binding.title.text = it.getString(titleNameKey)
        }

        binding.continueButton.setOnClickListener{

            val checkAllFields: Boolean = checkAllFields()

            if (checkAllFields) {
                findNavController().navigate(
                    R.id.action_electricityFormFragment_to_electricityPaymentMethodFragment2,
                    bundleOf(
                        SCNUMBERKEY to binding.customerScNumber.text.toString(),
                        CUSTOMERIDKEY to binding.electricityCustomerId.text.toString(),
                        COUNTERLOCATIONKEY to counterLocation
                    )
                )
            }
        }


        binding.backArrow.setOnClickListener()
        {
            findNavController().popBackStack()
        }

    }


    private fun setUpSpinnerAdapter() {
        adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.counter_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.onItemSelectedListener = this
        binding.spinner.adapter = adapter
    }


    private fun checkAllFields(): Boolean {
        binding.apply {
            if (customerScNumber.text.toString().isBlank()) {
                customerScNumber.error = "SC id is required"
                return false
            }
            if (electricityCustomerId.text.toString().isBlank()) {
                electricityCustomerId.error = "ID is required"
                return false
            }

            return true
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        counterLocation = parent?.getItemAtPosition(position).toString()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}