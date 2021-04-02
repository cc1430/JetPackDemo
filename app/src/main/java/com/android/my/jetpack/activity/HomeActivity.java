package com.android.my.jetpack.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.my.jetpack.R;
import com.android.my.jetpack.adapter.ItemListAdapter;
import com.android.my.jetpack.databinding.ActivityHomeBindingImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBindingImpl activityHomeBinding;
    ItemListAdapter itemListAdapter;
    List<String> dataList = new ArrayList<>();

    String[] strArray = new String[]{
            "初始化",
            "注册（含发送验证码）",
            "用户名密码登录",
            "手机验证码登录（含发送登录验证码）",
            "本机号码快捷登录",
            "获取二维码",
            "检查二维码状态",
            "手机扫码",
            "二维码授权登录",
            "刷新Token",
            "查询用户信息",
            "修改用户信息",
            "手机绑定机顶盒",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataList = Arrays.asList(strArray);
        itemListAdapter = new ItemListAdapter(this, dataList);
        itemListAdapter.setItemClickListener(itemClickListener);

        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        activityHomeBinding.rvList.setLayoutManager(new LinearLayoutManager(this));
        activityHomeBinding.rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        activityHomeBinding.rvList.setAdapter(itemListAdapter);
    }

    private ItemListAdapter.ItemClickListener itemClickListener = new ItemListAdapter.ItemClickListener() {
        @Override
        public void OnItemClick(View view, int position) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    };
}