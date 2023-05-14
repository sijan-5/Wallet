package com.generic.wallet.dashboard_one


class DashboardOneDataClass(
    val logoName: String,
    val imageResource: Int,
    val imageResource_bg_drawable: Int,
    val cashBackBoolean : Boolean = false,
    val onClick: () -> Unit
)