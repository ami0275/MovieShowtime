package com.amit.bms.core

import android.widget.ImageView
import coil.load


fun ImageView.loadImage(
    imageUrl: String
) {
    this.load(imageUrl)
}