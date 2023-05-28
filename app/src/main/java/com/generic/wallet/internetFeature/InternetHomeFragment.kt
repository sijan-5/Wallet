package com.generic.wallet.internetFeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.generic.wallet.bankTransferFeature.BankListAdapter
import com.generic.wallet.bankTransferFeature.BankLogoAndNameDataClass
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentInternetHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InternetHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InternetHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentInternetHomeBinding? = null
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

        _binding = FragmentInternetHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.internetRecyclerView.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
            binding.internetRecyclerView.adapter = BankListAdapter(getISPList()) {

            }
        }
        binding.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InternetHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InternetHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getISPList(): List<BankLogoAndNameDataClass> {
        return listOf(

            BankLogoAndNameDataClass(R.drawable.wlink_logo, "World Link"),
            BankLogoAndNameDataClass(R.drawable.vianet, "Vianet"),
            BankLogoAndNameDataClass(R.drawable.subisu, "SUBISU"),
            BankLogoAndNameDataClass(R.drawable.cgnet, "CG Net"),

            )
    }
}