package com.android.my.jetpack.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageBindingAdapter {

    @BindingAdapter("setImageUrl")
    public static void bindingImageUrl(ImageView imageView, String imageUrl) {
        RequestOptions options = new RequestOptions()
                .fitCenter();

        Glide.with(imageView)
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }
}
