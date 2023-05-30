package com.generic.wallet.bankTransferFeature

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class CommonUtilitiesDataClass (@DrawableRes val bankImageResource : Int, val itemName :String) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(bankImageResource)
        parcel.writeString(itemName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CommonUtilitiesDataClass> {
        override fun createFromParcel(parcel: Parcel): CommonUtilitiesDataClass {
            return CommonUtilitiesDataClass(parcel)
        }

        override fun newArray(size: Int): Array<CommonUtilitiesDataClass?> {
            return arrayOfNulls(size)
        }
    }
}