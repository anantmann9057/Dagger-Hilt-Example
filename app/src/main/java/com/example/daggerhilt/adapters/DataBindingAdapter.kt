package com.hunger.worries

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daggerhilt.R


class DataBindingAdapter {


    companion object {
        @JvmStatic
        @BindingAdapter("app:src")
        fun setSrc(imageView: ImageView?, imageURL: String?) {
            imageView?.scaleType = ImageView.ScaleType.FIT_XY
            if (imageURL != null) {
                Glide.with(imageView!!.context)
                    .load(imageURL)
                    .apply(RequestOptions().override(250, 250))
                    .fitCenter()
                    .thumbnail(
                        Glide.with(imageView.context).load(R.drawable.ic_launcher_background)
                            .thumbnail(0.1f)
                    )
                    .into(imageView)

            }

        }


        @SuppressLint("ClickableViewAccessibility")
        @JvmStatic
        @BindingAdapter("app:viewVisibility")
        fun setVisibility(view: View, boolean: Boolean) {
            if (boolean) {
                view.visibility = View.VISIBLE
            } else
                view.visibility = View.GONE

        }
    }


}