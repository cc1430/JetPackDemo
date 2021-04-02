package com.android.my.jetpack.model.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.android.my.jetpack.model.base.BaseEntity;

@Entity(tableName = "user_info")
public class UserInfoEntity extends BaseEntity {

    // 主键，是否自增长
    @PrimaryKey(autoGenerate = true)
    public int id;
    // 表中字段，表中字段名
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "sex")
    public String sex;

    @ColumnInfo(name = "phone")
    public String phone;

    @Ignore
    public UserInfoEntity() {
    }

    public UserInfoEntity(String name, int age, String sex, String phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
