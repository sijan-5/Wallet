package com.generic.wallet.profilefragmentexpandablelist

import ChildDataClass
import com.generic.wallet.R

class ExpandableListDataItems {

    private val profileItemHashMap: HashMap<GroupTitleDataClass, List<ChildDataClass>?> = HashMap()
    private var accountChildList: MutableList<ChildDataClass> = mutableListOf<ChildDataClass>()
    var supportChildList: MutableList<ChildDataClass> = mutableListOf()
    private var appChildList: MutableList<ChildDataClass> = mutableListOf<ChildDataClass>()
    private var settingChildList : MutableList<ChildDataClass> = mutableListOf()


    private val listOfGroupItem: List<GroupTitleDataClass> =
        listOf(
            GroupTitleDataClass(
                R.drawable.fill_kyc,
               R.color.fill_kyc_backgroundColor,
                "Fill Kyc"
            ),
            GroupTitleDataClass(
                R.drawable.account,
                R.color.internetBackground,
                "Account"
            ),
            GroupTitleDataClass(
                R.drawable.settings,
                R.color.settingBackgroundColor,
                "Settings"

            ),
            GroupTitleDataClass(
                R.drawable.app,
                R.color.appBackgroundColor,
                "App"
            ),
            GroupTitleDataClass(
                R.drawable.support,
                R.color.supportBackgroundColor,
                "Support"

            ),
        )


    fun getData(): HashMap<GroupTitleDataClass, List<ChildDataClass>?> {

        accountChildList.add(ChildDataClass("Link Bank Account"))
        accountChildList.add(ChildDataClass("Transaction Limit"))

        supportChildList.add(ChildDataClass("FAQs"))
        supportChildList.add(ChildDataClass("About Us"))
        supportChildList.add(ChildDataClass("Contact Us"))

        appChildList.add(ChildDataClass("Check For Update"))
        appChildList.add(ChildDataClass("Privacy Policy"))
        appChildList.add(ChildDataClass("Terms and condition"))

        settingChildList.add(ChildDataClass("Change Password"))
        settingChildList.add(ChildDataClass("Change Transaction Pin"))
        settingChildList.add(ChildDataClass("Enable Biometric Login", true))
        settingChildList.add(ChildDataClass("Enable Biometric Payment",true))
        settingChildList.add(ChildDataClass("Enable App Notification" , true))

        profileItemHashMap[this.listOfGroupItem[0]]   = null
        profileItemHashMap[this.listOfGroupItem[1]] = accountChildList
        profileItemHashMap[this.listOfGroupItem[2]] =settingChildList
        profileItemHashMap[this.listOfGroupItem[3]] =appChildList
        profileItemHashMap[this.listOfGroupItem[4]] = supportChildList


        return profileItemHashMap

    }


}

