package com.generic.wallet.waterFeature

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
import com.generic.wallet.databinding.FragmentWaterFormBinding


const val WATER_COUNTER_KEY = "waterCounterKey"
const val WATER_CUSTOMER_ID_KEY = "waterCustomerIdKey"
const val WATER_BOARD_TITLE_KEY = "waterBoardTitle"
class WaterForm : Fragment(){
    private var _binding : FragmentWaterFormBinding? = null
    private val binding get() = _binding!!
    private lateinit var counterName:String
    private lateinit var waterBoardTitle : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWaterFormBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpWaterSpinner()


        binding.apply{
            waterBoardTitle =  arguments?.getString(titleNameKey).toString()
            title.text = waterBoardTitle
            backArrow.setOnClickListener {
                findNavController().popBackStack()
            }

            continueButton.setOnClickListener {
                val checkEmptyField :Boolean = checkEmptyField()
                if (checkEmptyField) {
                    val waterBundle = bundleOf(
                        WATER_COUNTER_KEY to counterName,
                        WATER_CUSTOMER_ID_KEY to customerId.text.toString(),
                        WATER_BOARD_TITLE_KEY to waterBoardTitle
                    )
                    findNavController().navigate(
                        R.id.action_waterForm_to_waterPaymentMethod,
                        waterBundle
                    )
                }
            }
        }
    }


    private fun setUpWaterSpinner(){
        val adapter = ArrayAdapter.createFromResource(requireContext(),R.array.counter_array,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(com.chaos.view.R.layout.support_simple_spinner_dropdown_item)
        binding.waterSpinner.adapter = adapter
        binding.waterSpinner.onItemSelectedListener = selectedItem
    }


   private val selectedItem = object : AdapterView.OnItemSelectedListener{
       override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
           counterName = parent?.getItemAtPosition(position).toString()
       }
       override fun onNothingSelected(parent: AdapterView<*>?) {
       }

   }

    private fun checkEmptyField() :Boolean
    {
        if(binding.customerId.text.toString().isBlank())
        {
            binding.customerId.error = "This is required"
            return false
        }
        return true
    }
}