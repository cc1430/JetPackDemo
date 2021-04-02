package com.android.my.jetpack.model.base;

import android.util.Log;

import com.android.my.jetpack.model.base.callback.RequestCallback;
import com.android.my.jetpack.model.base.exception.ConnectionException;
import com.android.my.jetpack.model.base.exception.ResponseException;

import io.reactivex.observers.DisposableObserver;
import org.jetbrains.annotations.NotNull;

public class BaseSubscriber<T> extends DisposableObserver<T> {

    public static final String TAG = BaseSubscriber.class.getSimpleName();
    RequestCallback<T> mRequestCallback;

    public BaseSubscriber(RequestCallback<T> requestCallback) {
        this.mRequestCallback = requestCallback;
    }

    public void onComplete() {
        Log.d(TAG, "Request onComplete");
    }

    public void onError(Throwable e) {
        Log.e(TAG, e.getMessage());
        if (e instanceof ResponseException) {
            ResponseException rError = (ResponseException)e;
            this.mRequestCallback.onFail(rError);
        } else {
            this.mRequestCallback.onFail(new ConnectionException(400, e.getMessage()));
        }
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "HTTP is start");
    }

    public void onNext(@NotNull T resp) {
        if (this.mRequestCallback != null) {
            this.mRequestCallback.onSuccess(resp);
        }
    }

    public static final class CodeRule {
        static final int CODE_200 = 200;
        static final int CODE_220 = 220;
        static final int CODE_300 = 300;
        static final int CODE_330 = 330;
        static final int CODE_400 = 400;
        static final int CODE_500 = 500;
        static final int CODE_503 = 503;
        static final int CODE_502 = 502;
        static final int CODE_510 = 510;
        static final int CODE_530 = 530;
        static final int CODE_551 = 551;
        static final int CODE_552 = 552;

        public CodeRule() {
        }
    }
}
