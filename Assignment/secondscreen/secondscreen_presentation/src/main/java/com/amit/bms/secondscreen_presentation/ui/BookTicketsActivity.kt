package com.amit.bms.secondscreen_presentation.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.amit.bms.common_utils.Constants.ARGS_MOVIE_NAME
import com.amit.bms.common_utils.Navigator
import com.amit.bms.secondscreen_presentation.base.BaseActivity
import com.amit.bms.secondscreen_presentation.databinding.ActivitySecondBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookTicketsActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, BookTicketsActivity::class.java)

            activity.startActivity(intent)
        }
    }

    private var navController: NavController? = null

    var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
    }

    override fun initializeViews() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (doubleBackToExitPressedOnce) {
                    finish()
                    return
                }
                doubleBackToExitPressedOnce = true
                lifecycleScope.launch {
                    delay(2000L)
                    doubleBackToExitPressedOnce = false
                }
            }
        })
    }

    override fun initializeObservers() {

    }

}


object GoToBookTicketsActivity : Navigator {
    override fun navigate(activity: Activity, bundle: Bundle) {
        BookTicketsActivity.launchActivity(activity)
    }
}