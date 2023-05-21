package com.generic.wallet

import androidx.annotation.DrawableRes

data class GroupTitleDataClass(
    @DrawableRes val imageResource: Int,
    val backgroundColor: Int,
    val groupName : String,
)