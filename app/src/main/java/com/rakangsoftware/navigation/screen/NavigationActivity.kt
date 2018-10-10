package com.rakangsoftware.navigation.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.NavUtils
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import com.rakangsoftware.navigation.R
import kotlinx.android.synthetic.main.navigation_activity.*

class NavigationActivity : AppCompatActivity() {

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "A Navigation demo"
            subtitle = "Toolbar, bottom, up and drawer navigation"
            setDisplayHomeAsUpEnabled(true)
        }

        bottom_navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.local_bar -> nav_label.text = getString(R.string.bottom_nav_bar)
                R.id.local_coffee -> nav_label.text = getString(R.string.bottom_nav_coffee)
                R.id.local_florist -> nav_label.text = getString(R.string.bottom_nav_florist)
                else -> {

                }
            }
        }

        drawerToggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        )
        drawer_layout.addDrawerListener(drawerToggle)

        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.local_bar -> {
                    nav_label.text = getString(R.string.drawer_nav_bar)
                    drawer_layout.closeDrawer(Gravity.START)
                    true
                }
                R.id.local_coffee -> {
                    nav_label.text = getString(R.string.drawer_nav_coffee)
                    drawer_layout.closeDrawer(Gravity.START)
                    true
                }
                R.id.local_florist -> {
                    nav_label.text = getString(R.string.drawer_nav_florist)
                    drawer_layout.closeDrawers()
                    true
                }
                else -> false
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> NavUtils.navigateUpFromSameTask(this)
            R.id.local_bar -> nav_label.text = getString(R.string.toolbar_menu_bar)
            R.id.local_coffee -> nav_label.text = getString(R.string.toolbar_menu_coffee)
            R.id.local_florist -> SecondActivity.start(this)
        }
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

}
