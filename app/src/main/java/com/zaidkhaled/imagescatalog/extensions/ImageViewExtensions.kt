package com.zaidkhaled.imagescatalog.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.zaidkhaled.imagescatalog.common.constants.NetworkConstants.IMAGES_BASE_URL

fun ImageView.loadImage(url: String?, defaultImage: Int) {
    val fullUrl = when {
        url?.startsWith("/storage") == true -> {
            url
        }
        url?.startsWith("http") == false -> {
            IMAGES_BASE_URL + url
        }
        url == null -> {
            defaultImage
        }
        else -> {
            url
        }
    }
    Glide.with(this).load(fullUrl)
        .placeholder(defaultImage)
        .into(this)
}

fun ImageView.loadImage(imageId: Int?) {
    Glide.with(this).load(imageId)
        .into(this)
}