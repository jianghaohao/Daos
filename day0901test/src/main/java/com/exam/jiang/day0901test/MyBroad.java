package com.exam.jiang.day0901test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.exam.jiang.day0901t.R;

/**
 * Created by jianghao on 2016/9/1.
 */
public class MyBroad extends AppCompatActivity {
    public static final String ACTION_INTENT_TEST = "com.broadcast.test";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton=(Button)findViewById(R.id.tiao);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
                Intent intent = new Intent(ACTION_INTENT_TEST);
                sendBroadcast(intent);
            }
        });
    }
}
