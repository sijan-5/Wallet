package com.generic.wallet.dashboard

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private var listOfProfileItems = getListOfProfileItems()

    private fun getListOfProfileItems(): List<ProfileItems> {

       return  listOf(
           ProfileItems.DataClassForProfileItems(
               R.drawable.fill_kyc,
               R.color.fill_kyc_backgroundColor,
               "Fill Kyc"
           ),
           ProfileItems.DataClassForProfileItems(
               R.drawable.account,
               R.color.accountBackgroundColor, "Fill Kyc"
           ),

           ProfileItems.DataClassForProfileItems(
               R.drawable.settings,
               R.color.settingBackgroundColor, "Settings"
           ),

           ProfileItems.DataClassForProfileItems(
               R.drawable.app,
               R.color.appBackgroundColor, "App"
           ),

           ProfileItems.DataClassForProfileItems(
               R.drawable.support,
               R.color.supportBackgroundColor, "Support"
           ),
           ProfileItems.Divider,

           ProfileItems.DataClassForProfileItems(
              R.drawable.log,
               R.color.logoutBackgroundColor, "Log Out"
           )
        )
    }

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
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = ProfileItemAdapter(listOfProfileItems,requireContext())
    }


}

