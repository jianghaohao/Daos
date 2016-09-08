package com.exam.jiang.day0904;

import android.os.Bundle;

import im.quar.autolayout.AutoLayoutActivity;

public class BaseActivity extends AutoLayoutActivity {
    private Myapplicon my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        my = (Myapplicon) getApplication();
        my.addActivity(this);


    }


    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        my.removeActivity(this);
    }

}
