package com.generic.wallet.sendMoneyFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.generic.wallet.databinding.FragmentSendMoneySecondFormBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SendMoneySecondFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SendMoneySecondFormFragment : Fragment(){
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentSendMoneySecondFormBinding? = null
    private val binding get()= _binding

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
        _binding = FragmentSendMoneySecondFormBinding.inflate(inflater,container,false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SendMoneySecondForm.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SendMoneySecondFormFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}