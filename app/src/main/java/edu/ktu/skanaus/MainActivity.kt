package edu.ktu.skanaus

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import edu.ktu.skanaus.ui.edit.EditRecipeFragment
import edu.ktu.skanaus.util.dayNightPrefListener
import edu.ktu.skanaus.util.setDayNightMode

interface MyOnBackPressed {
    fun onBackPressed()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        // Register the day/night listener and set the day/night mode to what was previously saved.
        val sharedPrefs = this.getPreferences(Context.MODE_PRIVATE)
        sharedPrefs?.registerOnSharedPreferenceChangeListener(dayNightPrefListener)
        setDayNightMode(sharedPrefs)

        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return if (!calledMyOnBackPressed()) {
            navController.navigateUp()
        } else {
            true
        }
    }

    override fun onBackPressed() {
        if (!calledMyOnBackPressed()) {
            super.onBackPressed()
        }
    }

    private fun calledMyOnBackPressed(): Boolean {
        val navHostFragment = this.supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val fragments = navHostFragment?.childFragmentManager?.fragments
        for (f in fragments ?: listOf()) {
            if (f is EditRecipeFragment) {
                (f as MyOnBackPressed).onBackPressed()
                return true
            }
        }
        return false
    }
}
