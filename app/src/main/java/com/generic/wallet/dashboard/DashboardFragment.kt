package com.generic.wallet.dashboard


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
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

        val noOfColumns = 4

        val currentDestinationID = findNavController().currentDestination?.id
        Log.d("currentID", currentDestinationID.toString())
        //wallet Services
        binding.walletServicesRecyclerView.layoutManager = GridLayoutManager(
            requireContext(), noOfColumns, GridLayoutManager.VERTICAL,
            false
        )
        binding.walletServicesRecyclerView.adapter = DashBoardAdapter(getListWalletServices())

        //utilities
        binding.utilitiesRecyclerView.layoutManager = GridLayoutManager(
            requireContext(), noOfColumns, GridLayoutManager.VERTICAL,
            false
        )
        binding.utilitiesRecyclerView.adapter = DashBoardAdapter(getWalletUtilitiesServices())

        //merchants
        binding.merchantRecyclerView.layoutManager = GridLayoutManager(
            requireContext(), noOfColumns, GridLayoutManager.VERTICAL,
            false
        )
        binding.merchantRecyclerView.adapter = DashBoardAdapter(getMerchantServices())

        //clicking on profile icon
        binding.profileImageIcon.setOnClickListener {


            val activity = requireActivity()
            if (activity is BottomNavigationActivity) {

                val menuItem = activity.getMenuItem(R.id.profileFragment)
                NavigationUI.onNavDestinationSelected(menuItem, findNavController())

            }
        }

//        binding.walletServicesRecyclerView.addItemDecoration(GridLayoutDecorator(noOfColumns,requireContext()))
    }
    private fun getWalletUtilitiesServices(): List<DashBoardItemDataClass> {

        return listOf(
            DashBoardItemDataClass(
                R.drawable.top__up,
                resources.getString(R.string.top_up),
                R.drawable.top_up_background
            ) {
                findNavController().navigate(R.id.action_dashBoardFragment_to_top_up_feature)
            },
            DashBoardItemDataClass(
                R.drawable.landline,
                resources.getString(R.string.landline),
                R.drawable.landline_background
            ) {

                findNavController().navigate(R.id.action_dashBoardFragment_to_landline_feature_nav_graph)
            },
            DashBoardItemDataClass(
                R.drawable.electricity,
                resources.getString(R.string.electricity),
                R.drawable.electricitybackground
            ) {

                findNavController().navigate(R.id.action_dashBoardFragment_to_electricity_feature_nav_graph2)
            },
            DashBoardItemDataClass(
                R.drawable.internet,
                resources.getString(R.string.internet),
                R.drawable.internetbackground
            ) {

                findNavController().navigate(R.id.action_dashBoardFragment_to_internet_feature_nav_graph)
            },
            DashBoardItemDataClass(
                R.drawable.water,
                resources.getString(R.string.water),
                R.drawable.waterbackground
            ) {

                findNavController().navigate(R.id.action_dashBoardFragment_to_water_feature_nav_graph)
            },
            DashBoardItemDataClass(
                R.drawable.tv,
                resources.getString(R.string.tv),
                R.drawable.tvbackground
            ) {

            },
            DashBoardItemDataClass(
                R.drawable.datapack,
                resources.getString(R.string.dataPack),
                R.drawable.tvbackground
            ) {

            },
            DashBoardItemDataClass(
                R.drawable.more,
                resources.getString(R.string.more),
                R.drawable.tvbackground
            ) {

            }
        )


    }
    private fun getListWalletServices(): List<DashBoardItemDataClass> {


        return listOf(
            DashBoardItemDataClass(
                R.drawable.send_money,
                resources.getString(R.string.send_money),
                R.drawable.dashboard_one_icon_bg
            ) {
                findNavController().navigate(R.id.action_dashBoardFragment_to_send_money)
            },

            DashBoardItemDataClass(
                R.drawable.request_money,
                resources.getString(R.string.request_money),
                R.drawable.dashboard_one_icon_bg
            ) {
                findNavController().navigate(R.id.action_dashBoardFragment_to_send_money)
            },

            DashBoardItemDataClass(
                R.drawable.load_wallet,
                resources.getString(R.string.load_wallet),
                R.drawable.dashboard_one_icon_bg
            ) {

                findNavController().navigate(R.id.action_dashBoardFragment_to_load_wallet_nav_graph)
            },

            DashBoardItemDataClass(
                R.drawable.bank_transfer_01,
                resources.getString(R.string.bank_transfer),
                R.drawable.dashboard_one_icon_bg
            ) {
                findNavController().navigate(R.id.action_dashBoardFragment_to_bank_transfer_login_graph)
            }

        )
    }

    private fun getMerchantServices(): List<DashBoardItemDataClass> {
        return listOf(
            DashBoardItemDataClass(
                R.drawable.daraz,
                resources.getString(R.string.Daraz),
                R.drawable.dashboard_one_icon_bg
            ) {

            },
            DashBoardItemDataClass(
                R.drawable.foodmandu,
                resources.getString(R.string.food_mandu),
                R.drawable.dashboard_one_icon_bg
            ) {

            },
            DashBoardItemDataClass(
                R.drawable.platinum,
                resources.getString(R.string.platinum),
                R.drawable.dashboard_one_icon_bg
            ) {

            },
            DashBoardItemDataClass(
                R.drawable.aanapurna,
                resources.getString(R.string.aanapurna),
                R.drawable.dashboard_one_icon_bg
            ) {

            },

            )
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




