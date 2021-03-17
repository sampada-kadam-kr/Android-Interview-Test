package com.kroger.end

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithGlideApp(imageUrl: String?) {
    if (!imageUrl.isNullOrBlank()) {
        Glide.with(this)
            .load(imageUrl)
            .into(this)
    }
}