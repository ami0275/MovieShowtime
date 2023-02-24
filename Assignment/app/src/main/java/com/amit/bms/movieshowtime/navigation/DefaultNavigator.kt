package com.amit.bms.movieshowtime

import com.amit.bms.common_utils.Activities
import com.amit.bms.common_utils.Navigator
import com.amit.bms.firstscreen_presentation.ui.GoToShowTimeActivity
import com.amit.bms.secondscreen_presentation.ui.GoToBookTicketsActivity


class DefaultNavigator : Navigator.Provider {

    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.BookTicketsActivity -> {
                GoToBookTicketsActivity
            }
            Activities.ShowTimeActivity -> {
                GoToShowTimeActivity
            }
        }
    }
}