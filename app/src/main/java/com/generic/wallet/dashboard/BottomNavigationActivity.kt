package com.generic.wallet.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.generic.wallet.R
import com.generic.wallet.databinding.ActivityBottomNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)




//        navController = Navigation.findNavController(this, R.id.navHostFragment)
//        setupWithNavController(binding.bottomNavigationBottom,navController)


//        binding.bottomNavigationBottom.setupWithNavController(binding.fragmentContainer.findNavController())
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
       navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigation).setupWithNavController(navController)

    }
}