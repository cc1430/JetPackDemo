package com.android.my.jetpack.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;

import com.android.my.jetpack.model.base.repository.BaseRepository;

public class BaseViewModel extends AndroidViewModel {
    protected BaseRepository mRepository;
    protected LifecycleOwner mLifecycleOwner;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
    }
}