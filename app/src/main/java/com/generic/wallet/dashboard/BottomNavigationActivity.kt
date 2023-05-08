package com.generic.wallet.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
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

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
        navController = navHostFragment.navController

        //connecting bottom navigation with navHostContainer
        findViewById<BottomNavigationView>(R.id.bottomNavigation).apply {
            setupWithNavController(
                navController
            )

        }
    }


    fun getMenuItem( menuId: Int): MenuItem{
        return this.binding.bottomNavigation.menu.findItem(menuId)
    }

}