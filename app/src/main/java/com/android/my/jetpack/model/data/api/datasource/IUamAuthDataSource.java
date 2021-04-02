package com.android.my.jetpack.model.data.api.datasource;

import com.android.my.jetpack.model.data.entity.TokenEntity;
import com.android.my.jetpack.model.base.callback.RequestCallback;

public interface IUamAuthDataSource {

    void postToken(String clientId, String clientSecret, String grantType, RequestCallback<TokenEntity> callback);
}
