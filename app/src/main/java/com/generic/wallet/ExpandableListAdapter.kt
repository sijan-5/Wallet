package com.generic.wallet

import ChildDataClass
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat

class ExpandableListAdapter(
    private val context: Context,
    private val groupList: List<GroupTitleDataClass>,
    private val profileItemHashMap: HashMap<GroupTitleDataClass, List<ChildDataClass>?>
) : BaseExpandableListAdapter() {


    //get specified child from the given title
    override fun getChild(groupPosition: Int, childPosition: Int): Any {


        return   profileItemHashMap[groupList[groupPosition]]!![childPosition]

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

        val expandedListText = getChild(groupPosition, childPosition) as ChildDataClass

            val convertingView = convertView ?: kotlin.run {
                val layoutInflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                layoutInflater.inflate(R.layout.expandable_child_items, null)
            }


            val childTextView = convertingView.findViewById<TextView>(R.id.expandedChildList)
            val switch = convertingView.findViewById<SwitchCompat>(R.id.switchElement)
            childTextView.text = expandedListText.childName


            if (expandedListText.showSwitch) {
                switch.visibility = View.VISIBLE
            } else {
                switch.visibility = View.GONE
            }

            return convertingView
        }



    // return number of child in each group
    override fun getChildrenCount(groupPosition: Int): Int {
        return profileItemHashMap[groupList[groupPosition]]?.size ?: 0
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
//            convertingView.findViewById<ImageView>(R.id.greaterIcon)
//                .setImageResource(R.drawable.drop_arrow)

            val bitMap = BitmapFactory.decodeResource(context.resources, R.drawable.greater_icon)
            val rotatedImage = getRotatedDrawable(bitMap,45f)

            convertingView.findViewById<ImageView>(R.id.greaterIcon)
                .setImageDrawable(rotatedImage)

        } else {
            convertingView.findViewById<ImageView>(R.id.greaterIcon)
                .setImageResource(R.drawable.greater_icon)
        }

        val profileItemImage = convertingView.findViewById<ImageView>(R.id.profileItemImage)
        val profileItemText = convertingView.findViewById<TextView>(R.id.profileItemText)

        profileItemImage.setImageResource(groupObject.imageResource)

        profileItemImage.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, groupObject.backgroundColor))
        profileItemText.text = groupObject.groupName
        return convertingView
    }

    override fun hasStableIds(): Boolean = false

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true


    fun getRotatedDrawable(bitmap : Bitmap, angle : Float): Drawable
    {
        val drawable = object : BitmapDrawable(context.resources, bitmap)
        {
            override fun draw(canvas: Canvas) {
                canvas.save()
                canvas.rotate(angle,bitmap.width /2f , bitmap.height/2f)
                super.draw(canvas)
                canvas.restore()
            }
        }
        return drawable
    }

}