package com.generic.wallet.internetFeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.dashboard.titleNameKey
import com.generic.wallet.databinding.FragmentInternetFormBinding


const val INTERNET_TITLE = "internetTitle"
const val INTERNET_USERNAME = "internetUserName"
class InternetFormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentInternetFormBinding? = null
    private val binding get() = _binding!!
    private lateinit var internetTitleName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInternetFormBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }
        internetTitleName = arguments?.getString(titleNameKey).toString()
        binding.title.text = internetTitleName
        binding.continueButton.setOnClickListener {
            val checkField : Boolean = checkEmptyField()
            if(checkField)
            {
                val internetBundle : Bundle = bundleOf(INTERNET_TITLE to internetTitleName, INTERNET_USERNAME to binding.userName.text.toString())
                findNavController().navigate(R.id.action_internetFormFragment_to_internetPaymentMethodForm, internetBundle)

            }
        }
    }
    private fun checkEmptyField():Boolean
    {
        if(binding.userName.text.toString().isBlank())
        {
            binding.userName.error = "This is required"
            return false
        }
        return  true
    }
}