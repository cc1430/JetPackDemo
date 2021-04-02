package com.android.my.jetpack.http.uamauth;

import com.android.my.jetpack.http.BaseApi;

public class UamAuthApi extends BaseApi {

    private static UamAuthApi mInstance;

    public UamAuthApi() {
        super();
    }

    public static UamAuthApi getInstance() {
        if (mInstance == null) {
            synchronized (UamAuthApi.class) {
                mInstance = new UamAuthApi();
            }
        }
        return mInstance;
    }

    @Override
    public String getBaseUrl() {
        return "http://apigw-gateway.wasumedia.cn/uamauth/oauth/";
    }

    public IUamAuth getApi() {
        return mRetrofitHelper.build().create(IUamAuth.class);
    }
}
