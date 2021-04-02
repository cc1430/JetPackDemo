package com.android.my.jetpack.http;

public abstract class BaseApi {

    protected RetrofitHelper mRetrofitHelper;

    public BaseApi() {
        if (this.mRetrofitHelper == null) {
            this.mRetrofitHelper = new RetrofitHelper(getBaseUrl());
            this.mRetrofitHelper.init();
        }
    }

    public abstract String getBaseUrl();
}
