package com.android.my.jetpack.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.my.jetpack.R;
import com.android.my.jetpack.model.data.dao.UserInfoDao;
import com.android.my.jetpack.model.data.entity.TokenEntity;
import com.android.my.jetpack.model.data.entity.UserInfoEntity;
import com.android.my.jetpack.model.db.UserInfoDatabase;
import com.android.my.jetpack.viewmodel.AuthViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    AuthViewModel authViewModel;

    EditText editTextId, editTextName, editTextAge, editTextSex, editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        authViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(AuthViewModel.class);
        authViewModel.setLifecycleOwner(this);
        authViewModel.authToken("c1", "123", "client_credentials");

        authViewModel.getTokenResultMutableLiveData().observe(this, new Observer<TokenEntity>() {
            @Override
            public void onChanged(TokenEntity tokenEntity) {
                Toast.makeText(LoginActivity.this, tokenEntity.toString(), Toast.LENGTH_LONG).show();
            }
        });


        editTextId = findViewById(R.id.et_id);
        editTextName = findViewById(R.id.et_name);
        editTextAge = findViewById(R.id.et_age);
        editTextSex = findViewById(R.id.et_sex);
        editTextPhone = findViewById(R.id.et_phone);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_update).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        try {
            if (id == R.id.btn_query) {
                UserInfoDao userInfoDao = UserInfoDatabase.getInstance(getApplication()).getUserInfoDao();
                List<UserInfoEntity> list = userInfoDao.queryAllUserInfo();
                for (UserInfoEntity userInfoEntity: list) {
                    Log.d("chenchen", "userInfoEntity: " + userInfoEntity.toString());
                }
            } else if (id == R.id.btn_update) {
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.name = editTextName.getText().toString();
                userInfoEntity.age = Integer.parseInt(editTextAge.getText().toString());
                userInfoEntity.sex = editTextSex.getText().toString();
                userInfoEntity.phone = editTextPhone.getText().toString();
                UserInfoDao userInfoDao = UserInfoDatabase.getInstance(getApplication()).getUserInfoDao();
                userInfoDao.updateUserInfo(userInfoEntity);
            } else if (id == R.id.btn_delete) {
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.id = Integer.parseInt(editTextId.getText().toString());
                UserInfoDao userInfoDao = UserInfoDatabase.getInstance(getApplication()).getUserInfoDao();
                userInfoDao.deleteUserInfo(userInfoEntity);
            } else if (id == R.id.btn_add) {
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.name = editTextName.getText().toString();
                userInfoEntity.age = Integer.parseInt(editTextAge.getText().toString());
                userInfoEntity.sex = editTextSex.getText().toString();
                userInfoEntity.phone = editTextPhone.getText().toString();
                UserInfoDao userInfoDao = UserInfoDatabase.getInstance(getApplication()).getUserInfoDao();
                userInfoDao.insertUserInfo(userInfoEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}