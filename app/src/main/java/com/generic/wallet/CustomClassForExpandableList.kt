package com.generic.wallet

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.LinearLayout


class CustomClassForExpandableList : ExpandableListView{

    constructor(context:Context , attrs : AttributeSet, defStyle : Int) : super(context, attrs, defStyle)

    constructor(context: Context, attrs: AttributeSet) : super(context,attrs)

    constructor(context: Context) : super(context)

//    override fun setAdapter(adapter: ExpandableListAdapter?) {
//        super.setAdapter(adapter)
//
//    }
//
//    override fun setOnChildClickListener(onChildClickListener: OnChildClickListener?) {
//        super.setOnChildClickListener(onChildClickListener)
//    }
//
//
//    override fun expandGroup(groupPos: Int) : Boolean {
//        return super.expandGroup(groupPos)
//    }
//
//    override fun expandGroup(groupPos: Int, animate: Boolean) : Boolean {
//        return super.expandGroup(groupPos, animate)
//    }
//
//    override fun isGroupExpanded(groupPosition: Int): Boolean {
//        return super.isGroupExpanded(groupPosition)
//    }
//



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
            Int.MAX_VALUE shr 20, MeasureSpec.AT_MOST
        )
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom)

        val viewGroupParams = (layoutParams as ViewGroup.LayoutParams)
        viewGroupParams.height = measuredHeight

    }

}

