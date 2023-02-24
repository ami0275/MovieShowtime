package com.amit.bms.firstscreen_presentation.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.amit.bms.common_utils.Constants
import com.amit.bms.common_utils.Navigator
import com.amit.bms.firstscreen_presentation.R
import com.amit.bms.firstscreen_presentation.base.BaseActivity
import com.amit.bms.firstscreen_presentation.databinding.ActivityShowtimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowTimeActivity : BaseActivity<ActivityShowtimeBinding>(ActivityShowtimeBinding::inflate) {

    companion object {
        fun launchActivity(activity: Activity, bundle: Bundle) {
            val intent = Intent(activity, ShowTimeActivity::class.java)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }
    }

    private val navController by lazy {
        findNavController(R.id.home_nav_graph)
    }


    override fun initializeViews() {
        //TODO("Not yet implemented")
    }

    override fun initializeObservers() {
        //TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        val args = intent.extras?.let { bundle ->
            val movieName = bundle.getString(Constants.ARGS_MOVIE_NAME).toString()
        }
    }
}


object GoToShowTimeActivity : Navigator {
    override fun navigate(activity: Activity, bundle: Bundle) {
        ShowTimeActivity.launchActivity(activity, bundle)
    }
}