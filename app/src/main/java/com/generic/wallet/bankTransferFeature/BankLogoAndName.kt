package com.generic.wallet.bankTransferFeature

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class BankLogoAndNameDataClass (@DrawableRes val bankImageResource : Int, val bankTextView :String?) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(bankImageResource)
        parcel.writeString(bankTextView)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BankLogoAndNameDataClass> {
        override fun createFromParcel(parcel: Parcel): BankLogoAndNameDataClass {
            return BankLogoAndNameDataClass(parcel)
        }

        override fun newArray(size: Int): Array<BankLogoAndNameDataClass?> {
            return arrayOfNulls(size)
        }
    }
}