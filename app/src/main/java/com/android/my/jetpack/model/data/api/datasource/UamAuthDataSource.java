package com.android.my.jetpack.model.data.api.datasource;

import com.android.my.jetpack.model.data.entity.TokenEntity;
import com.android.my.jetpack.http.uamauth.UamAuthApi;
import com.android.my.jetpack.model.base.callback.RequestCallback;
import com.android.my.jetpack.model.base.datasource.BaseRemoteDataSource;

public class UamAuthDataSource extends BaseRemoteDataSource implements IUamAuthDataSource{

    @Override
    public void postToken(String clientId, String clientSecret, String grantType, RequestCallback<TokenEntity> callback) {
        execute(UamAuthApi.getInstance().getApi().postToken(clientId, clientSecret, grantType), callback);
    }
}
