package com.myspace.spaceflightnews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myspace.spaceflightnews.R
import com.myspace.spaceflightnews.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        // tab -> also import the library required -> removes anything after it
        // enter -> only autofils and you need to import

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView

        navController = findNavController(R.id.nav_host_fragment)

        val appConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_blog,
                R.id.navigation_article
            )
        )

        setupActionBarWithNavController(navController, appConfiguration)
        navView.setupWithNavController(navController)


//        navController.addOnDestinationChangedListener{ _, destination, _ ->
//            when(destination.id) {
//                R.id.navigation_article -> {
//                    navView.visibility = View.VISIBLE
//                }
//
//                else -> {
//                    // VISIBLE -> make it visible?
//                    // INVISIBLE -> hide it but keep the dimensions
//                    // GONE -> hide it and remove the dimiensions as well
//                    navView.visibility = View.GONE
//                }
//            }
//        }

    }

    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}