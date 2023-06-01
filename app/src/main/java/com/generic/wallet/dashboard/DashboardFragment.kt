package com.generic.wallet.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import com.generic.wallet.R
import com.generic.wallet.bankTransferFeature.CommonUtilitiesDataClass
import com.generic.wallet.databinding.FragmentDashboardBinding


const val DASHBOARD_ITEM_KEY: String = "KeyForDashboardItems"
const val TITLE_KEY: String = "keyForTitle"
class DashboardFragment : Fragment() {
    private val noOfColumns = 4
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!


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
        //wallet Services
        setUpRecyclerViews()
        //clicking on profile icon
        binding.profileImageIcon.setOnClickListener {
            val activity = requireActivity()
            if (activity is BottomNavigationActivity) {
                val menuItem = activity.getMenuItem(R.id.profileFragment)
                NavigationUI.onNavDestinationSelected(menuItem, findNavController())
            }
        }
    }

    private fun setUpRecyclerViews() {
        setUpServicesRecyclerView()
        setUpMerchantRecyclerView()
        setUpUtilitiesRecyclerView()
    }

    private fun setUpUtilitiesRecyclerView() {
        binding.utilitiesRecyclerView.apply {
            layoutManager =
                GridLayoutManager(requireContext(), noOfColumns, GridLayoutManager.VERTICAL, false)
            adapter = DashBoardAdapter(getWalletUtilitiesServices())
        }
    }

    private fun setUpMerchantRecyclerView() {
        binding.merchantRecyclerView.apply {
            layoutManager =
                GridLayoutManager(requireContext(), noOfColumns, GridLayoutManager.VERTICAL, false)
            adapter = DashBoardAdapter(getMerchantServices())
        }

    }

    private fun setUpServicesRecyclerView() {
        binding.walletServicesRecyclerView.apply {
            layoutManager =
                GridLayoutManager(requireContext(), noOfColumns, GridLayoutManager.VERTICAL, false)
            adapter = DashBoardAdapter(getListWalletServices())
        }
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
                val bundle = bundleOf(
                    DASHBOARD_ITEM_KEY to electricityBoardList(),
                    TITLE_KEY to resources.getString(R.string.electricity)
                )
                navigateToCommonPage(bundle)
            },
            DashBoardItemDataClass(
                R.drawable.internet,
                resources.getString(R.string.internet),
                R.drawable.internetbackground
            )
            {
                val bundle = bundleOf(
                    DASHBOARD_ITEM_KEY to getISPList(),
                    TITLE_KEY to resources.getString(R.string.internet)
                )
                navigateToCommonPage(bundle)
            },
            DashBoardItemDataClass(
                R.drawable.water,
                resources.getString(R.string.water),
                R.drawable.waterbackground
            ) {
                val bundle = bundleOf(
                    DASHBOARD_ITEM_KEY to getListOfWaterServices(),
                    TITLE_KEY to resources.getString(R.string.water)
                )
                navigateToCommonPage(bundle)
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


    private fun electricityBoardList(): List<CommonUtilitiesDataClass> = mutableListOf(
            CommonUtilitiesDataClass(R.drawable.nea, "NEA"),
            CommonUtilitiesDataClass(R.drawable.slrec, "SLREC")
        )


    private fun getISPList(): ArrayList<CommonUtilitiesDataClass> = arrayListOf(
            CommonUtilitiesDataClass(R.drawable.wlink_logo, "World Link"),
            CommonUtilitiesDataClass(R.drawable.vianet, "Vianet"),
            CommonUtilitiesDataClass(R.drawable.subisu, "SUBISU"),
            CommonUtilitiesDataClass(R.drawable.cgnet, "CG Net"))

    private fun getListOfWaterServices(): ArrayList<CommonUtilitiesDataClass> = arrayListOf(
            CommonUtilitiesDataClass(R.drawable.nwsc, "NWSC"),
            CommonUtilitiesDataClass(R.drawable.kukl_logo, "KUKL"),
            CommonUtilitiesDataClass(R.drawable.community_khanepani, "Community KhanePani"))

    private fun navigateToCommonPage(bundle: Bundle? = null) {
        view?.findNavController()
            ?.navigate(R.id.action_dashBoardFragment_to_commonUtilitiesRecycler, bundle)
    }

}




