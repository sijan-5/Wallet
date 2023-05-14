package com.generic.wallet.dashboard_four

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.generic.wallet.R
import com.generic.wallet.dashboard.DashBoardAdapter
import com.generic.wallet.dashboard.DashBoardItemDataClass
import com.generic.wallet.dashboard_one.DashboardOneAdapter
import com.generic.wallet.dashboard_one.DashboardOneDataClass
import com.generic.wallet.dashboard_third.AdapterThirdServices
import com.generic.wallet.databinding.FragmentDashboardFourHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFourHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFourHome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentDashboardFourHomeBinding? = null
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
        _binding = FragmentDashboardFourHomeBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //services
        binding.servicesRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
        binding.servicesRecyclerView.adapter =
                DashBoardAdapter(getServices())

        //utilities
        binding.utilitiesRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
        binding.utilitiesRecyclerView.adapter =
            DashboardOneAdapter(getUtilities())

        //utilities
        binding.merchantRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
        binding.merchantRecyclerView.adapter =
            DashboardOneAdapter(getMerchant())
    }

    private fun getUtilities(): List<DashboardOneDataClass> {
        return listOf(
            DashboardOneDataClass(
                resources.getString(R.string.top_up),
                R.drawable.top_up_b,
                R.drawable.icon_back_ground,
                true
            ) {},
            DashboardOneDataClass(
                resources.getString(R.string.landline),
                R.drawable.landline_b,
                R.drawable.landline_background,

                ) {},
            DashboardOneDataClass(
                resources.getString(R.string.electricity),
                R.drawable.electricity_b,
                R.drawable.electricitybackground,
            ) {},
            DashboardOneDataClass(
                resources.getString(R.string.internet),
                R.drawable.internet_b,
                R.drawable.internetbackground,
                true
            ) {},

            DashboardOneDataClass(
                resources.getString(R.string.water),
                R.drawable.water_b,
                R.drawable.waterbackground,

                ) {},
            DashboardOneDataClass(
                resources.getString(R.string.tv),
                R.drawable.tv_b,
                R.drawable.tvbackground,

                ) {},

            DashboardOneDataClass(
                resources.getString(R.string.dataPack),
                R.drawable.data_pack_b,
                R.drawable.datapackbackground

            ) {},

            DashboardOneDataClass(
                resources.getString(R.string.more),
                R.drawable.more_b,
                R.drawable.morebackground,
            ) {},

            )
    }


    private fun getServices(): List<DashBoardItemDataClass> {
        return listOf(

            DashBoardItemDataClass(
                R.drawable.send_money,
                resources.getString(R.string.send_money),
                R.drawable.icon_back_ground
            ) {},

            DashBoardItemDataClass(
                R.drawable.request_money,
                resources.getString(R.string.request_money),
                R.drawable.icon_back_ground
            ) {},

            DashBoardItemDataClass(
                R.drawable.load_wallet,
                resources.getString(R.string.load_wallet),
                R.drawable.icon_back_ground
            ) {},

            DashBoardItemDataClass(
                R.drawable.bank_transfer_01,
                resources.getString(R.string.bank_transfer),
                R.drawable.icon_back_ground
            ) {}

        )
    }


    private fun getMerchant(): List<DashboardOneDataClass> {
        return listOf(
            DashboardOneDataClass(
                resources.getString(R.string.Daraz),
                R.drawable.daraz,
                R.drawable.dashboard_one_icon_bg
            ){},
            DashboardOneDataClass(
                resources.getString(R.string.food_mandu),
                R.drawable.foodmandu,
                R.drawable.dashboard_one_icon_bg
            ){},
            DashboardOneDataClass(
                resources.getString(R.string.annapurna),
                R.drawable.aanapurna,
                R.drawable.dashboard_one_icon_bg
            ){},
            DashboardOneDataClass(
                resources.getString(R.string.platinum),
                R.drawable.platinum,
                R.drawable.dashboard_one_icon_bg
            ){}
        )

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFourHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFourHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}