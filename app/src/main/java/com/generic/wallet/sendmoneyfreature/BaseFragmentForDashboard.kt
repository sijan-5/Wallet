package com.generic.wallet.sendmoneyfreature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.generic.wallet.databinding.FragmentBaseForDashboardBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BaseFragmentForDashboard.newInstance] factory method to
 * create an instance of this fragment.
 */
abstract class BaseFragmentForDashboard : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentBaseForDashboardBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    abstract fun getTitle(): String
    abstract fun getView(inflater: LayoutInflater): View?
    abstract fun goToPreviousFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBaseForDashboardBinding.inflate(inflater)

        val frameLayout = binding.frameLayout
        var title = binding.title
        title.text = getTitle()

        val serviceView = getView(inflater)
        frameLayout.addView(serviceView)

        return binding.root

//       return inflater.inflate(R.layout.fragment_base_for_dashboard,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {

            goToPreviousFragment()
        }
    }



}

