package dev.ilhamsuaib.navi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.plusAssign
import androidx.navigation.ui.setupWithNavController
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.common.KeepStateNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.mainNavHost)
        val navHostFragment: Fragment = supportFragmentManager.findFragmentById(R.id.mainNavHost)!!
        val navigator = KeepStateNavigator(
            this,
            navHostFragment.childFragmentManager,
            R.id.mainNavHost
        )

        //register a custom navigator to navigatorProvider
        navController.navigatorProvider.plusAssign(navigator)
        navController.setGraph(R.navigation.nav_main)

        bottomNav.setupWithNavController(navController)
    }
}
