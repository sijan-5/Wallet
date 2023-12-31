package com.generic.wallet.authfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.generic.wallet.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        val navController = navHostFragment.navController

        val data = intent.getStringExtra("actionFromMainActivity")

        if (data == "pressedSkip" || data == "logInText") {

            navController.navigate(
                resId = R.id.action_registerFragment_to_logInFragment,
            )


        }



//            findNavController(R.id.registerFragment).navigate(R.id.action_registerFragment_to_logInFragment)
    }


}
