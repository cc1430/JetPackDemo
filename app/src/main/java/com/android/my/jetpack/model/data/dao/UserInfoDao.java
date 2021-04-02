package com.android.my.jetpack.model.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.android.my.jetpack.model.data.entity.UserInfoEntity;

import java.util.List;

@Dao
public interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserInfo(UserInfoEntity userInfoEntity);

    @Update
    int updateUserInfo(UserInfoEntity userInfoEntity);

    @Delete
    void deleteUserInfo(UserInfoEntity userInfoEntity);

    @Query("SELECT * FROM USER_INFO ORDER BY ID DESC")
    List<UserInfoEntity> queryAllUserInfo();
}
