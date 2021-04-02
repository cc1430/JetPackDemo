package com.android.my.jetpack.model.db;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.my.jetpack.model.data.dao.UserInfoDao;
import com.android.my.jetpack.model.data.entity.UserInfoEntity;

/**
 * 首先定义一个抽象类继承RoomDatabase类，并添加注解 @Database 来标识：
 */
@Database(entities = UserInfoEntity.class, version = 1)
public abstract class UserInfoDatabase extends RoomDatabase {

    private static UserInfoDatabase instance;

    public static UserInfoDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application.getApplicationContext(), UserInfoDatabase.class, "user.db")
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract UserInfoDao getUserInfoDao();
}
