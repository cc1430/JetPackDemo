package com.android.my.jetpack.model.data.api.repository;

import androidx.lifecycle.MutableLiveData;

import com.android.my.jetpack.model.data.entity.TokenEntity;
import com.android.my.jetpack.model.base.callback.RequestCallback;
import com.android.my.jetpack.model.base.exception.BaseException;
import com.android.my.jetpack.model.base.repository.BaseRepository;
import com.android.my.jetpack.model.data.api.datasource.IUamAuthDataSource;

public class UamAuthRepository extends BaseRepository<IUamAuthDataSource> {

    public UamAuthRepository(IUamAuthDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public MutableLiveData<TokenEntity> authToken(String clientId, String clientSecret, String grantType) {
        MutableLiveData<TokenEntity> liveData = new MutableLiveData<>();
        mRemoteDataSource.postToken(clientId, clientSecret, grantType, new RequestCallback<TokenEntity>() {
            @Override
            public void onSuccess(TokenEntity data) {
                liveData.setValue(data);
            }

            @Override
            public void onFail(BaseException exception) {

            }
        });
        return liveData;
    }
}
