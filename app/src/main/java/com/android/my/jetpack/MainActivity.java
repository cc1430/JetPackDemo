package com.android.my.jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.my.jetpack.activity.HomeActivity;
import com.android.my.jetpack.bean.LiveData;
import com.android.my.jetpack.databinding.ActivityMainBindingImpl;
import com.android.my.jetpack.viewmodel.LiveDataViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBindingImpl activityMainBinding;
    LiveDataViewModel liveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        liveDataViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(LiveDataViewModel.class);
        liveDataViewModel.getMutableLiveData().observe(this, new Observer<LiveData>() {
            @Override
            public void onChanged(LiveData liveData) {
                activityMainBinding.setLiveData(liveData);
            }
        });

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setControl(this);

        LiveData liveData = new LiveData();
        liveData.setImageUrl("http://125.210.130.14:8080/IP/uploadChannelImg/541.png");
        liveData.setTitle("浙江卫视");
        liveDataViewModel.updateLiveData(liveData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 事件绑定
     */
    public void onChangeButtonClick(View v) {
        LiveData liveData = liveDataViewModel.getMutableLiveData().getValue();
        liveData.setImageUrl("http://125.210.130.14:8080/IP/uploadChannelImg/526.png");
        liveData.setTitle("湖南卫视");
        liveDataViewModel.updateLiveData(liveData);
    }

    public void onImageClick(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}