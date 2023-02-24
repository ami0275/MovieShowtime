package com.amit.bms.common_utils

import android.app.Activity
import android.os.Bundle

interface Navigator {

    fun navigate(activity:Activity,bundle:Bundle)

    interface Provider{
        fun getActivities(activities: Activities):Navigator
    }

}