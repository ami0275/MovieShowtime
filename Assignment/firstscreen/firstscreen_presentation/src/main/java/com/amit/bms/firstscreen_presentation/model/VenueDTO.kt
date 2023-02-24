package com.amit.bms.firstscreen_presentation.models

import android.os.Parcelable
import com.amit.bms.common_utils.ListItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class VenueDTO(
    val name: String,
    val showDate: String,
    val showtimes: List<ShowtimeDTO>
): Parcelable,ListItem