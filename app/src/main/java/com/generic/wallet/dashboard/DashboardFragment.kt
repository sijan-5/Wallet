package com.generic.wallet.dashboard

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generic.wallet.R
import com.generic.wallet.databinding.FragmentDashboardBinding
import org.w3c.dom.Text

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
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val array = listOf(
            R.drawable.send_money,
            R.drawable.request_money,
            R.drawable.load_wallet,
            R.drawable.bank_transfer_01
        )

        val linearLayout = binding.servicesHorizontalLayout

        linearLayout.apply {
            orientation = LinearLayout.HORIZONTAL
            array.forEach {
                val imageView = ImageView(requireContext())

                imageView.layoutParams = LayoutParams(
                    0,
                    LayoutParams.WRAP_CONTENT, 1.0f
                ).apply {
                    setMargins(50, 16, 12, 50)
                }

                imageView.setPadding(20, 40, 20, 40)
                imageView.setBackgroundResource(R.drawable.wallet_corner_radius)

                imageView.setImageResource(it)
                addView(imageView)
            }
            gravity = Gravity.CENTER_VERTICAL


            (layoutParams as ConstraintLayout.LayoutParams).setMargins(
                16, 50, 16, 0
            )
        }

        class ViewHolder(val textView:TextView): RecyclerView.ViewHolder(textView) {
            fun setText(text:String){
                textView.text = text
            }

        }

        val items = (1..100).map {
            "Hello $it"
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        binding.recyclerView.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                return ViewHolder(
                    TextView(context)
                )
            }

            override fun getItemCount(): Int {
               return items.size
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                items[position].let {
                    holder.setText(it)
                }
            }

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


