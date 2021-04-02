package com.android.my.jetpack.model.base.datasource;

import com.android.my.jetpack.model.base.BaseSubscriber;
import com.android.my.jetpack.model.base.callback.RequestCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class BaseRemoteDataSource {
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BaseRemoteDataSource() {
    }

    protected <T> void execute(Observable observable, RequestCallback<T> callback) {
        this.execute(observable, new BaseSubscriber(callback), true);
    }

    public <T> void executeWithoutDismiss(Observable observable, RequestCallback<T> callback) {
        this.execute(observable, new BaseSubscriber(callback), false);
    }

    protected <T> void executeQuietly(Observable observable, RequestCallback<T> callback) {
        this.executeQuietly(observable, (Observer)(new BaseSubscriber(callback)));
    }

    private void execute(Observable observable, Observer observer, boolean isDismiss) {
        Disposable disposable = (Disposable)observable.throttleFirst(500L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer);
        this.addDisposable(disposable);
    }

    private void executeQuietly(Observable observable, Observer observer) {
        Disposable disposable = (Disposable)observable.throttleFirst(500L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer);
        this.addDisposable(disposable);
    }

    private void addDisposable(Disposable disposable) {
        this.mCompositeDisposable.add(disposable);
    }

    public void dispose() {
        if (!this.mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.dispose();
        }

    }
}
