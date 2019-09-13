package dev.ilhamsuaib.navi.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
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

        toolbar.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)

        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notifManager.createNotificationChannel(
                NotificationChannel(
                    "channelId", "Deep Links", NotificationManager.IMPORTANCE_HIGH
                )
            )
        }

        val notificationBuilder = NotificationCompat.Builder(this, "channelId")
            .setContentTitle("Navigation")
            .setContentText("Deep link to Android")
            .setSmallIcon(R.drawable.ic_notifications)
            .setAutoCancel(true)

        val deepLinkBuilder = NavDeepLinkBuilder(this)
            .setGraph(R.navigation.nav_home)
            .setDestination(R.id.detailFragment)
            .setArguments(bundleOf("name" to "Ilham Suaib"))
            .createPendingIntent()

        notificationBuilder.setContentIntent(deepLinkBuilder)

        notifManager.notify(0, notificationBuilder.build())
    }
}
