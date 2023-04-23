package com.generic.wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation_graph) as NavHostFragment

        val navController = navHostFragment.navController

        val data = intent.getStringExtra("actionFromMainActivity")

        if (data == "pressedSkip" || data == "logInText") {

            navController.navigate(
                resId = R.id.action_registerFragment_to_logInFragment,
                navOptions = NavOptions.Builder().setPopUpTo(
                    R.id.action_registerFragment_to_logInFragment,
                    true
                ).build(), args = null
            )
        }

    }
}