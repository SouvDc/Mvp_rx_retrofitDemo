package com.mvp_rx_retrofitdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mvp_rx_retrofitdemo.MyApplication;
/**
 * Created by wangjitao on 2016/11/8 0008.
 * 基类Activity的封装
 * 一般使用mvp模式的话会在BaseActivity中进行P和V的初始化绑定
 */
public abstract class BaseActivity extends AppCompatActivity  {
    private final String TAG = "BaseActivity";
    protected Activity mContext;


    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = this;
        MyApplication.getInstance().addActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "super onDestroy");
        MyApplication.getInstance().removeActivity(this);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}