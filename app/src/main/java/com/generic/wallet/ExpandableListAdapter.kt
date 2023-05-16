package com.generic.wallet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListAdapter(
    private val context: Context,
    private val expandableTitleList: List<String>,
    private val hasMapForTitleAndChild: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {


    //get specified child from the given title
    override fun getChild(groupPosition: Int, childPosition: Int): Any {

        return hasMapForTitleAndChild[expandableTitleList[groupPosition]]!![childPosition]
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
        return hasMapForTitleAndChild[expandableTitleList[groupPosition]]!!.size
    }

    //return group
    override fun getGroup(groupPosition: Int): Any {
        return expandableTitleList[groupPosition]
    }

    //return number of group
    override fun getGroupCount(): Int {
        return expandableTitleList.size
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
        val groupText = getGroup(groupPosition) as String
        val convertingView = convertView ?: run {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layoutInflater.inflate(R.layout.expandable_list_title, null)
        }

        val groupTextView = convertingView.findViewById<TextView>(R.id.expandedListTitle)
        groupTextView.text = groupText

        return convertingView
    }

    override fun hasStableIds(): Boolean = false

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true


}