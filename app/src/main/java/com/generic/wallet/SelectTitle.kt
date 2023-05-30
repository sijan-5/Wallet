package com.generic.wallet

import android.content.Context


enum class SelectTitle(private val titleId:Int) {

    Electricity(R.string.electricity),
    Water(R.string.water),
    Internet(R.string.internet);


   fun getTitle(context:Context) = context.resources.getString(titleId)
}