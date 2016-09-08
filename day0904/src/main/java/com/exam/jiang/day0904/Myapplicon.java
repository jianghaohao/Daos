package com.exam.jiang.day0904;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghao on 2016/9/6.
 */
public class Myapplicon extends Application {

    List<Activity> list=new ArrayList<Activity>();
    @Override
    public void onCreate() {
        super.onCreate();

    }
    public void addActivity(Activity context)
    {
        list.add(context);
    }

    public void removeActivity(Activity context)
    {
        list.remove(context);
    }
    public void finishall()
    {
        for (Activity ll : list) {
            if(!ll.isFinishing())
            {
                ll.finish();
            }
        }
    }
    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub
        finishall();
        super.onTerminate();
    }
}
