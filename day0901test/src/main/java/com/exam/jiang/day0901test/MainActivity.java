package com.exam.jiang.day0901t;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button  mButton=(Button)findViewById(R.id.tiao);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //默认浏览器
//                Intent intent =new Intent();
//
//                intent.setAction("android.intent.action.VIEW");
//                Uri content_url =Uri.parse("http://www.163.com");
//                intent.setData(content_url);
//                startActivity(intent);
                //系统自带浏览器
                Intent intent =new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url =Uri.parse("http://www.163.com");
                intent.setData(content_url);
                intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
                startActivity(intent);

//                uc浏览器"："com.uc.browser", "com.uc.browser.ActivityUpdate“
//                opera浏览器："com.opera.mini.android", "com.opera.mini.android.Browser"
//                qq浏览器："com.tencent.mtt", "com.tencent.mtt.MainActivity"
            }
        });
    }
}
