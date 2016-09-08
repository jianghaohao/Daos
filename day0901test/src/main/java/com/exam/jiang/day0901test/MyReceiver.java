package com.exam.jiang.day0901test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.exam.jiang.day0901t.MainActivity;

/**
 * Created by jianghao on 2016/9/1.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MYMYMY","收到广播");
         Intent mIntent=new Intent( context, MainActivity.class);

        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mIntent.putExtra("ss","实时");
         context.startActivity(mIntent);
    }
}
