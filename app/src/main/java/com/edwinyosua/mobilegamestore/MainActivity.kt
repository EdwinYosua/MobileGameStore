package com.edwinyosua.mobilegamestore

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.edwinyosua.mobilegamestore.databinding.ActivityMainBinding
import com.edwinyosua.mobilegamestore.ui.home.HomeFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //disable night mode in app


        //for Drawer Navigation
        drawer = binding.drawerLayout
        binding.apply {
            val toggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawer,
                appBarMain.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            drawer.addDrawerListener(toggle)
            toggle.syncState()
            drawerNav.setNavigationItemSelectedListener(this@MainActivity)

            if (savedInstanceState != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, HomeFragment())
                    .commit()
                supportActionBar?.title = getString(R.string.app_name)
            }
        }


//in case i need bottom navigation later
//        val navView: BottomNavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment: Fragment? = null
        var title: String = getString(R.string.app_name)
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }

            R.id.navigation_favorite -> Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT)
                .show()

            R.id.navigation_shop_cart -> Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT)
                .show()
        }
        supportActionBar?.title = title

        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }

        drawer.closeDrawer(GravityCompat.START)

        return true

    }


}