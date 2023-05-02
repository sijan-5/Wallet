package com.generic.wallet.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentDashboardBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentDashboardBinding? = null
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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.sendMoney.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_send_money)
        }
        binding.requestMoney.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_send_money)

        }
        binding.loadWallet.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_load_wallet_nav_graph)

        }
        binding.bankTransfer.setOnClickListener {

            findNavController().navigate(R.id.action_dashBoardFragment_to_bank_transfer_login_graph)

        }
        binding.topUp.setOnClickListener {

            findNavController().navigate(R.id.action_dashBoardFragment_to_top_up_feature)

        }
        binding.landLine.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_landline_feature_nav_graph)

        }
        binding.electricity.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_electricity_feature_nav_graph)

        }
        binding.internet.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_internet_feature_nav_graph)

        }
        binding.water.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_water_feature_nav_graph)

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}


