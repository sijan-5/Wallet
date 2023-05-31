package com.generic.wallet.dashboard

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes


sealed class ProfileItems {
    data class DataClassForProfileItems(
        @DrawableRes val imageResource: Int,
        @ColorRes val backgroundColorId: Int,
        val serviceName: String
    ) : ProfileItems()

    object Divider : ProfileItems()

}