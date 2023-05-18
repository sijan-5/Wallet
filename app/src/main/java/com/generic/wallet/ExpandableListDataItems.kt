package com.generic.wallet

import android.accounts.Account
import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat

class ExpandableListDataItems {

    private val profileItemHashMap: HashMap<GroupTitleDataClass, List<String>> = HashMap()
    private var accountChildList: MutableList<String> = mutableListOf<String>()
    var supportChildList: MutableList<String> = mutableListOf<String>()
    private var appChildList: MutableList<String> = mutableListOf<String>()


    private val listOfGroupItem: List<GroupTitleDataClass> =
        listOf(
            GroupTitleDataClass(
                R.drawable.fill_kyc,
               R.color.fill_kyc_backgroundColor,
                "Fill Kyc"
            ),
            GroupTitleDataClass(
                R.drawable.profile,
                R.color.internetBackground,
                "Account"
            ),
            GroupTitleDataClass(
                R.drawable.settings,
                R.color.settingBackgroundColor,
                "Settings"

            ),   GroupTitleDataClass(
                R.drawable.support,
                R.color.supportBackgroundColor,
                "Support"

            ),
            GroupTitleDataClass(
                R.drawable.app,
                R.color.appBackgroundColor,
                "App"
            ),
        )


    fun getData(): HashMap<GroupTitleDataClass, List<String>> {

        accountChildList.add("Link bank Account")
        accountChildList.add("Transaction Limit")

        supportChildList.add("FAQs")
        supportChildList.add("About Us")
        supportChildList.add("Contact Us")

        appChildList.add("Link Bank Account")
        appChildList.add("Transaction Limit")

        profileItemHashMap[this.listOfGroupItem[0]] = accountChildList
        profileItemHashMap[this.listOfGroupItem[1]] = supportChildList
        profileItemHashMap[this.listOfGroupItem[2]] = appChildList
        profileItemHashMap[this.listOfGroupItem[3]] = appChildList
        profileItemHashMap[this.listOfGroupItem[4]] = appChildList


        return profileItemHashMap

    }


}

