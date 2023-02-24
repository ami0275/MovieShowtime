package com.amit.bms.common_utils.utils

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime



@ExperimentalTime
fun getDateDiff(oldDate: Long): Long {
    return try {
        TimeUnit.DAYS.convert(Calendar.getInstance().timeInMillis - oldDate, TimeUnit.MILLISECONDS)
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
}


fun getMinDiff(oldDate: Long): Long {
    return try {
        TimeUnit.MINUTES.convert(Calendar.getInstance().timeInMillis - oldDate, TimeUnit.MILLISECONDS)
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
}

fun getRandomNumbersInRange(min: Long, max: Long): Long {
    return (min..max).random()
}

fun millisToMinutesAndSecond(millis: Long): String {
    val minutes = (millis / 1000) / 60
    val seconds = (millis / 1000) % 60
    return if (seconds < 10){
        "${minutes}.0${seconds}"
    }else{
        "${minutes}.${seconds}"
    }

    fun TextView.setTextColorRes(@ColorRes colorRes: Int) {
        val color = ContextCompat.getColor(context, colorRes)
        setTextColor(color)
    }
}
