package com.android.my.jetpack.model.base.callback;


import com.android.my.jetpack.model.base.exception.BaseException;

public interface RequestCallback<T> {
    void onSuccess(T data);

    void onFail(BaseException exception);
}
