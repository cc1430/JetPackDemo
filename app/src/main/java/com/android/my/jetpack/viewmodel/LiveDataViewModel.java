package com.android.my.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.my.jetpack.bean.LiveData;

public class LiveDataViewModel extends ViewModel {

    MutableLiveData<LiveData> mutableLiveData = new MutableLiveData<>();

    public void updateLiveData(LiveData liveData) {
        mutableLiveData.setValue(liveData);
    }

    public MutableLiveData<LiveData> getMutableLiveData() {
        return mutableLiveData;
    }
}
