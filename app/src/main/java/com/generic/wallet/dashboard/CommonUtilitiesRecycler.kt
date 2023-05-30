package com.generic.wallet.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.generic.wallet.R
import com.generic.wallet.SelectTitle
import com.generic.wallet.bankTransferFeature.CommonDashboardItemAdapter
import com.generic.wallet.bankTransferFeature.CommonUtilitiesDataClass
import com.generic.wallet.databinding.FragmentCommonUtilitiesRecyclerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
const val itemNameKey: String = "ItemNameKey"

class CommonUtilitiesRecycler : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentCommonUtilitiesRecyclerBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCommonUtilitiesRecyclerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//
//        val myArrayList: ArrayList<BankLogoAndNameDataClass> =
//            arguments?.getParcelableArrayList<BankLogoAndNameDataClass>(key)

        val bundle = arguments

        if (bundle != null) {
            val list: List<CommonUtilitiesDataClass> =
                bundle.getParcelableArrayList<CommonUtilitiesDataClass>(key)!!
            Log.d("array size", "${list.size}")

            val getTitle = bundle.getString(titlekey)
            binding.title.text = getTitle

            binding.commonRecyclerView.apply {
                layoutManager =
                    GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
                adapter = CommonDashboardItemAdapter(list) { itemName ->

                    val itemNameBundle = bundleOf(itemNameKey to itemName)
                    navigateToSelectDashboardItem(getTitle, itemNameBundle)
                }
            }


        } else {
            Log.d("is bundle", "Bundle is null")
        }

        binding.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun navigateToSelectDashboardItem(titleName: String?, bundle: Bundle) {
        when (titleName) {
            SelectTitle.Electricity.getTitle(requireContext()) -> findNavController().navigate(
                R.id.action_commonUtilitiesRecycler_to_electricity_feature_nav_graph, bundle
            )
            SelectTitle.Water.getTitle(requireContext()) -> findNavController().navigate(R.id.action_commonUtilitiesRecycler_to_water_feature_nav_graph,bundle)
            else -> findNavController().navigate(R.id.action_commonUtilitiesRecycler_to_internet_feature_nav_graph,bundle)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommonUtilitiesRecycler.
         */
        // TODO: Rename and change types and number of parameters

        fun newInstance(
            electricityBoardList: List<CommonUtilitiesDataClass>, x: Int
        ) {


        }
    }
}