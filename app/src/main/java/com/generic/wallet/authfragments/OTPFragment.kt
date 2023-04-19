package com.generic.wallet.authfragments

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.sample01.R
import com.generic.wallet.databinding.FragmentOTPBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OTPFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OTPFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentOTPBinding?= null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOTPBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
//        return inflater.inflate(com.generic.wallet.R.layout.fragment_o_t_p, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toBeColor = resources.getString(com.generic.wallet.R.string.recieve_code)
        val spannableString = SpannableString(toBeColor)
        val color = ContextCompat.getColor(requireContext(),R.color.button_purple)
        spannableString.setSpan(ForegroundColorSpan(color), 26,39,Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        binding.timer.text = spannableString
        binding.secondContinueButton.setOnClickListener {
            findNavController().navigate(com.generic.wallet.R.id.action_OTPFragment_to_setPasswordFragment)
        }

    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OTPFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OTPFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}