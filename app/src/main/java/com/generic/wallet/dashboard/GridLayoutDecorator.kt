package com.generic.wallet.dashboard

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContentProviderCompat
import androidx.recyclerview.widget.RecyclerView

class GridLayoutDecorator(private val numberOfColumns: Int, val context: Context) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val pxValue = dpToPixel(24f)
//        if (position == 0)
//        {
//            outRect.left = 0
//        }
//        else if(position == 3)
//        {
//            outRect.right = 0
//        }
        view.setPadding(
            if (position % numberOfColumns != 0) pxValue.toInt() else 0,
            0,
            if (position % numberOfColumns != numberOfColumns - 1) pxValue.toInt() else 0,
            0
        )

    }


    private fun dpToPixel(dp: Float): Double {
        val screenPixelDensity = context.resources.displayMetrics.density
        return ((dp * screenPixelDensity) + 0.5)

    }
}
