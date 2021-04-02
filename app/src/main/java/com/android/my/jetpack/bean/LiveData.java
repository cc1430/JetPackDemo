package com.android.my.jetpack.bean;

import android.graphics.drawable.Drawable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LiveData extends BaseObservable {

    private String title;
    private Drawable imageSrc;
    private String imageUrl;

    @Bindable
    public Drawable getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(Drawable imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
