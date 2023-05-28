package com.generic.wallet.profilefragmentexpandablelist

import androidx.annotation.DrawableRes

data class GroupTitleDataClass(
    @DrawableRes val imageResource: Int,
    val backgroundColor: Int,
    val groupName : String,
)