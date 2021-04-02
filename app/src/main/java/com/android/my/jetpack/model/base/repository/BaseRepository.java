package com.android.my.jetpack.model.base.repository;

public class BaseRepository<T> {
    protected T mRemoteDataSource;

    public BaseRepository(T remoteDataSource) {
        this.mRemoteDataSource = remoteDataSource;
    }
}