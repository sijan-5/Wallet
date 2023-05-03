package com.generic.wallet.loadWalletFeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.generic.wallet.bankTransferFeature.BankListAdapter
import com.generic.wallet.bankTransferFeature.BankLogoAndNameDataClass
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentLoadWalletHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoadWalletHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoadWalletHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentLoadWalletHomeBinding?= null
    private val binding get() = _binding!!

    private val loadFundingItemsList = getLoadFundingItems()


    private fun getLoadFundingItems() : List<LoadWalletDataClass>
    {
        return listOf(
            LoadWalletDataClass(R.drawable.m_bank, "M-Banking"){

                if(findNavController().currentDestination?.id == R.id.loadWalletHomeFragment)
                {
                    findNavController().navigate(R.id.action_loadWalletHomeFragment_to_bank_transfer_login_graph)
                }
            },
            LoadWalletDataClass(R.drawable.e_bank, "E-Banking") {

                Toast.makeText(requireContext(),"clicked", Toast.LENGTH_LONG).show()
            },
            LoadWalletDataClass(R.drawable.link_fill0_wght100_grad_25_opsz48, "Linked Bank"){
                Toast.makeText(requireContext(),"clicked", Toast.LENGTH_LONG).show()
            },

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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoadWalletHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loadWalletRecyclerView.layoutManager = GridLayoutManager(requireContext(),4,GridLayoutManager.VERTICAL,
        false)

        binding.loadWalletRecyclerView.adapter = LoadWalletAdapter(loadFundingItemsList){

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
         * @return A new instance of fragment LoadWalletHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoadWalletHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}