package com.generic.wallet.dashboard

import android.widget.ImageView
import androidx.annotation.DrawableRes

data class DashBoardItemDataClass(
    @DrawableRes val imageResource: Int,
    val logoName: String,
    @DrawableRes val backGroundResource: Int,
    val clickedItem: () -> Unit
)