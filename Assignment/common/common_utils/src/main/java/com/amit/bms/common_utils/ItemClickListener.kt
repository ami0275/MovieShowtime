package com.amit.bms.common_utils

import android.view.View

interface ItemClickListener<T> {
    fun onClick(item: T, position: Int, view: View)
}
