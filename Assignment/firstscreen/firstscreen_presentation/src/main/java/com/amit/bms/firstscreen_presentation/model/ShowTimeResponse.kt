package com.amit.bms.firstscreen_presentation.models

import android.os.Parcelable
import com.amit.bms.common_utils.ListItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowTimeResponse(
    val venues: List<VenueDTO>
): Parcelable,ListItem