package com.edwinyosua.mobilegamestore

import android.content.Intent
import android.net.Uri
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

    private var _binding: ActivityMainBinding? = null
    private lateinit var drawer: DrawerLayout
    private lateinit var fragment: Fragment

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        setSupportActionBar(_binding?.appBarMain?.toolbar)
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
                fragment = HomeFragment()
                supportActionBar?.title = getString(R.string.app_name)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var title: String = getString(R.string.app_name)
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
                observeFragment(fragment)
            }

            R.id.navigation_favorite -> {
                val uri = Uri.parse("mobilegamestore://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }

            R.id.navigation_shop_cart -> Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT)
                .show()
        }
        supportActionBar?.title = title

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    private fun observeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }

}