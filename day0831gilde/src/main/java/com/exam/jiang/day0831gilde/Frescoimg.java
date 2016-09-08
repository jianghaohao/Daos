package com.exam.jiang.day0831gilde;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by jianghao on 2016/8/31.
 */
public class Frescoimg extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.two_activity);
        SimpleDraweeView mSimpleDraweeView=(SimpleDraweeView)findViewById(R.id.simpleDraweeView);
        //获取网络的图片
       mSimpleDraweeView.setImageURI(Uri.parse("http://scimg.jb51.net/allimg/160813/103-160Q3143110P5.jpg"));
        //获取本地的图片
//        mSimpleDraweeView.setImageURI(Uri.parse("res://com.exam.jiang.day0831gilde/"+R.drawable.error));

    }
}
