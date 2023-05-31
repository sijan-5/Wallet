package com.generic.wallet.bankTransferFeature

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommonUtilitiesDataClass (@DrawableRes val bankImageResource : Int, val itemName :String) :Parcelable