package com.generic.wallet.dashboard_third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.generic.wallet.R
import com.generic.wallet.bankTransferFeature.CommonUtilitiesDataClass
import com.generic.wallet.dashboard.DashBoardAdapter
import com.generic.wallet.dashboard.DashBoardItemDataClass
import com.generic.wallet.dashboard_one.DashboardOneDataClass
import com.generic.wallet.databinding.FragmentDashBoardThirdHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashBoardThirdHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashBoardThirdHome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentDashBoardThirdHomeBinding? = null
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
        _binding = FragmentDashBoardThirdHomeBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //services
        binding.servicesRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.servicesRecyclerView.adapter =
            AdapterThirdServices(getServices())

        //utilities
        binding.utilitiesRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
        binding.utilitiesRecyclerView.adapter =
            AdapterThirdRecentPayments(getUtilities())

        //utilities
        binding.merchantRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
        binding.merchantRecyclerView.adapter =
            DashBoardAdapter(getMerchant())
    }


    private fun getUtilities(): List<CommonUtilitiesDataClass> {
        return listOf(
            CommonUtilitiesDataClass(
                R.drawable.ncell_l,
                resources.getString(R.string.ncell_top_up),
            ),
            CommonUtilitiesDataClass(
                R.drawable.dish_home,
                resources.getString(R.string.dish_home_price),
            ),

            CommonUtilitiesDataClass(
                R.drawable.wlink_logo,
                resources.getString(R.string.world_link),
            ),

            CommonUtilitiesDataClass(
                R.drawable.nea,
                resources.getString(R.string.nea),
            )
        )
    }

    private fun getServices(): List<DashboardOneDataClass> {
        return listOf(
            DashboardOneDataClass(
                resources.getString(R.string.send_money),
                R.drawable.send_money_l,
                R.drawable.dashboard_one_icon_bg,
            ) {},
            DashboardOneDataClass(
                resources.getString(R.string.request_money),
                R.drawable.request_money_l,
                R.drawable.dashboard_one_icon_bg,
            ) {},
            DashboardOneDataClass(
                resources.getString(R.string.load_wallet),
                R.drawable.load_wallet_l,
                R.drawable.dashboard_one_icon_bg,
            ) {},
            DashboardOneDataClass(
                resources.getString(R.string.bank_transfer),
                R.drawable.bank_transfer_01_l,
                R.drawable.dashboard_one_icon_bg,
            ) {},
        )
    }


    private fun getMerchant(): List<DashBoardItemDataClass> {
        return listOf(
            DashBoardItemDataClass(
                R.drawable.daraz,
                resources.getString(R.string.Daraz),
                R.drawable.dashboard_one_icon_bg
            ) {} ,
                    DashBoardItemDataClass(
                R.drawable.foodmandu,
                resources.getString(R.string.food_mandu),
                R.drawable.dashboard_one_icon_bg
            ) {} ,
        DashBoardItemDataClass(
                R.drawable.aanapurna,
                resources.getString(R.string.aanapurna),
                R.drawable.dashboard_one_icon_bg
            ) {},
            DashBoardItemDataClass(
                R.drawable.platinum,
                resources.getString(R.string.platinum),
                R.drawable.dashboard_one_icon_bg
            ) {} )

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashBoardThirdHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardThirdHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}