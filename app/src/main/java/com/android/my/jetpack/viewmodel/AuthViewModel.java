package com.android.my.jetpack.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.android.my.jetpack.model.data.entity.TokenEntity;
import com.android.my.jetpack.model.data.api.datasource.UamAuthDataSource;
import com.android.my.jetpack.model.data.api.repository.UamAuthRepository;

public class AuthViewModel extends BaseViewModel {

    private MutableLiveData<TokenEntity> tokenResultMutableLiveData = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UamAuthRepository(new UamAuthDataSource());
    }

    public void authToken(String clientId, String clientSecret, String grantType) {
        ((UamAuthRepository) mRepository).authToken(clientId, clientSecret, grantType).observe(mLifecycleOwner, new Observer<TokenEntity>() {
            @Override
            public void onChanged(TokenEntity tokenResult) {
                tokenResultMutableLiveData.setValue(tokenResult);
            }
        });
    }

    public MutableLiveData<TokenEntity> getTokenResultMutableLiveData() {
        return tokenResultMutableLiveData;
    }
}
