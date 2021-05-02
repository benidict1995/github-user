package com.benidict.core.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageUtil {
    fun loadImage(url: String?= null, view: ImageView){
        Glide
            .with(view.context)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(view)
    }
}