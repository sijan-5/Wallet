package com.example.sample01.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sample01.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val BOLD_TEXT_KEY = "Bold_Text"
private const val IMAGE_ID_KEY = "On_Board_Images"
private const val LOREM_TEXT = "LOREM"

class OnBoardFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var boldText: TextView
    private lateinit var displayImage: ImageView
    private lateinit var loremText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        boldText = view.findViewById(R.id.middleBoldText)
        displayImage = view.findViewById(R.id.instantPayImage)
        loremText = view.findViewById(R.id.loremText)

        val bundle = this.arguments
        bundle?.let {
            boldText.text = it.getString(BOLD_TEXT_KEY, "Default")
            displayImage.setImageResource(it.getInt(IMAGE_ID_KEY))
            loremText.text = it.getString(LOREM_TEXT,"Default")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(titleAndImage: PagerAdapter.OnBoardScreenParameter) =
            OnBoardFragment().apply {
                arguments = Bundle().apply {
                    putString(BOLD_TEXT_KEY, titleAndImage.title)
                    putInt(IMAGE_ID_KEY, titleAndImage.imageId)
                    putString(LOREM_TEXT, titleAndImage.loremText)
                }
            }
    }
}