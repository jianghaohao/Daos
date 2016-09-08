package com.exam.jiang.news.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.exam.jiang.news.adapter.LocationAdapter;
import com.exam.jiang.news.application.ManageApplication;
import com.exam.jiang.news.bean.City;
import com.exam.jiang.news.dao.DBUtils;
import com.exam.jiang.news.dao.MyDatabaseOpenHelper;

import java.util.ArrayList;

/**
 * Created by luo-pc on 2016/6/23.
 */
public class CityManage extends AppCompatActivity {
    private ListView lv_city;
    private ArrayList<City> cities;
    private static final String TAG = "CityManage";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province_list);
        ((ManageApplication) getApplication()).addToList(CityManage.this);
        setTitle(getIntent().getStringExtra("province name"));
        initView();
        initData();
        LocationAdapter cityAdapter = new LocationAdapter(this);
        cityAdapter.setCities(cities);
        lv_city.setAdapter(cityAdapter);
        lv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(CityManage.this, CountyManage.class);
                intent.putExtra("city code", cities.get(position).getCityCode());
                intent.putExtra("city name", cities.get(position).getCityName());
                Log.i(TAG, cities.get(position).getCityCode());
                startActivity(intent);
            }
        });
    }


    private void initView() {
        lv_city = (ListView) findViewById(R.id.lv_location);
    }

    private void initData() {
        MyDatabaseOpenHelper mdb = new MyDatabaseOpenHelper(this);
        SQLiteDatabase db = mdb.getReadableDatabase();
        DBUtils dbUtils = DBUtils.getInstance(db);
        cities = dbUtils.loadCity(getIntent().getStringExtra("province code"));
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }
}
