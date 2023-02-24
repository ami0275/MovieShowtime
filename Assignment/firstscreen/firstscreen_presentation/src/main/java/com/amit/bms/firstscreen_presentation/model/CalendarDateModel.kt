package com.amit.bms.firstscreen_presentation.model

import android.os.Parcelable
import com.amit.bms.common_utils.ListItem
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class CalendarDateModel(var date: Date, var isSelected: Boolean = false): Parcelable,
    ListItem {

    val calendarDay: String
        get() = SimpleDateFormat("EE", Locale.getDefault()).format(date)

    val calendarDate: String
        get() {
            val cal = Calendar.getInstance()
            cal.time = date
            return cal[Calendar.DAY_OF_MONTH].toString()
        }
}
