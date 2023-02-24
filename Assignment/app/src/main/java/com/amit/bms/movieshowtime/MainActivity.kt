package com.amit.bms.movieshowtime


import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.amit.bms.common_utils.Activities
import com.amit.bms.common_utils.Constants.BMS_SPLASH_LOGO
import com.amit.bms.common_utils.Navigator
import com.amit.bms.core.loadImage
import com.amit.bms.movieshowtime.databinding.ActivityMainBinding
import com.amit.bms.secondscreen_presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    @Inject
    lateinit var provider: Navigator.Provider

    override fun initializeViews() {

        // loading image using extension function
        binding.imageCta.loadImage(
            imageUrl = BMS_SPLASH_LOGO
        )

        lifecycleScope.launch {
            /*
            In place of delay we can sync data for App initialization process
             */
            delay(2000L)
            val bundle = Bundle()
            provider.getActivities(Activities.BookTicketsActivity)
                .navigate(this@MainActivity as Activity, bundle)
            finish()
        }

    }

    override fun initializeObservers() {
        binding.imageCta.setOnClickListener {
            val bundle = Bundle()
            provider.getActivities(Activities.BookTicketsActivity).navigate(this, bundle)
            finish()
        }
    }
}