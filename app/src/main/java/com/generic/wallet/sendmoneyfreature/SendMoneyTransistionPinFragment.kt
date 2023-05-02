package com.generic.wallet.sendmoneyfreature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentSendMoneyTransistionPinBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SendMoneyTransistionPinFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SendMoneyTransistionPinFragment : BaseFragmentForDashboard(){
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentSendMoneyTransistionPinBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun getTitle(): String {

        return resources.getString(R.string.enter_transistion_pin)
    }

    override fun getView(inflater: LayoutInflater): View {

        _binding = FragmentSendMoneyTransistionPinBinding.inflate(inflater)
        return binding.root
    }

    override fun goToPreviousFragment() {
       findNavController().popBackStack()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        _binding = FragmentSendMoneyTransistionPinBinding.inflate(inflater,container,false)
//        return binding?.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pinConfirmButton.setOnClickListener {
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SendMoneyTransistionPin.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SendMoneyTransistionPinFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}