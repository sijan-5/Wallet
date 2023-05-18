package com.generic.wallet

import android.content.Context
import android.content.res.ColorStateList
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class ExpandableListAdapter(
    private val context: Context,
    private val groupList: List<GroupTitleDataClass>,
    private val profileItemHashMap: HashMap<GroupTitleDataClass, List<String>>
) : BaseExpandableListAdapter() {


    //get specified child from the given title
    override fun getChild(groupPosition: Int, childPosition: Int): Any {

        return profileItemHashMap[groupList[groupPosition]]!![childPosition]
    }


    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }


    //get the view set child to it and retrurn view
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {


        val expandedListText = getChild(groupPosition, childPosition) as String
        val convertingView = convertView ?: kotlin.run {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layoutInflater.inflate(R.layout.expandable_child_items, null)
        }


        val childTextView = convertingView!!.findViewById<TextView>(R.id.expandedChildList)
        childTextView.text = expandedListText
        return childTextView!!
    }


    // return number of child in each group
    override fun getChildrenCount(groupPosition: Int): Int {
        return profileItemHashMap[groupList[groupPosition]]!!.size
    }

    //return group
    override fun getGroup(groupPosition: Int): Any {
        return groupList[groupPosition]
    }

    //return number of group
    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupObject = getGroup(groupPosition) as GroupTitleDataClass
        val convertingView = convertView ?: run {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layoutInflater.inflate(R.layout.expandable_list_title, null)
        }

        if (isExpanded) {
            convertingView.findViewById<ImageView>(R.id.greaterIcon)
                .setImageResource(R.drawable.drop_arrow)
        } else {
            convertingView.findViewById<ImageView>(R.id.greaterIcon)
                .setImageResource(R.drawable.greater_icon)
        }

        val profileItemImage = convertingView.findViewById<ImageView>(R.id.profileItemImage)
        val profileItemText = convertingView.findViewById<TextView>(R.id.profileItemText)

        profileItemImage.setImageResource(groupObject.imageResource)

        profileItemImage.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,groupObject.backgroundColor))
        profileItemText.text = groupObject.groupName
        return convertingView
    }

    override fun hasStableIds(): Boolean = false

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true


}