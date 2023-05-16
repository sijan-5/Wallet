package com.generic.wallet.dashboard_one


class DashboardOneDataClass(
    val logoName: String,
    val imageResource: Int,
    val imageResource_bg_drawable: Int,
    val cashBackBoolean : Boolean = false,
    val minCashBackPercentage : Float = 0.00f,
    val maxCashBackPercentage : Float = 0.00f,
    val onClick: () -> Unit
)