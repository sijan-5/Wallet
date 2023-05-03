package com.generic.wallet.loadWalletFeature

import androidx.annotation.DrawableRes


data class LoadWalletDataClass(
    @DrawableRes val imageResource: Int, val imageViewName: String,
    val onClickListener: () -> Unit
)
