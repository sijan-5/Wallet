package com.generic.wallet

import android.content.Context

class ExpandableListDataItems {


    companion object {
        val profileItemHashMap: HashMap<String, List<String>> = HashMap()
        var accountChildList: MutableList<String> = mutableListOf<String>()
        var supportChildList: MutableList<String> = mutableListOf<String>()
        var appChildList: MutableList<String> = mutableListOf<String>()
        fun getData(): HashMap<String, List<String>> {

            accountChildList.add("Link bank Account")
            accountChildList.add("Transaction Limit")

            supportChildList.add("FAQs")
            supportChildList.add("About Us")
            supportChildList.add("Contact Us")

            appChildList.add("Check for Update")
            appChildList.add("Privacy Policy")
            appChildList.add("Terms and Condition")

            profileItemHashMap["Account"] = accountChildList
            profileItemHashMap["Support"] = supportChildList
            profileItemHashMap["App"] = appChildList

            return profileItemHashMap

        }
    }

}
