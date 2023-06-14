package org.d3if0103.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if0103.assessment.util.MyTimer

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var myTimer: MyTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myTimer = MyTimer()
        Log.i("MainActivity", "onCreate dijalankan")

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onStart() {
        super.onStart()
        myTimer.startTimer()
        Log.i("MainActivity", "onStart dijalankan")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume dijalankan")
    }

    override fun onPause() {
        Log.i("MainActivity", "onPause dijalankan")
        super.onPause()
    }

    override fun onStop() {
        Log.i("MainActivity", "onStop dijalankan")
        myTimer.stopTimer()
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("MainActivity", "onDestroy dijalankan")
        super.onDestroy()
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}