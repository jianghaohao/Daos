package com.exam.jiang.day0901recycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private List<DataBean> picList;
    //图片
    private String[] str = {
            "http://p1.so.qhimg.com/t0126e5dbc54bd112ab.jpg",
            "http://imga1.pic21.com/bizhi/131211/05080/s11.jpg",
            "http://up.qqjia.com/z/02/tu4084_3.jpg",
            "http://www.bz55.com/uploads/allimg/150706/139-150F6164352.jpg",
            "http://www.qqya.com/qqyaimg/allimg/140507/201AM409-0.jpg",
            "http://tupian.qqjay.com/u/2012/1222/9_234739_2.jpg",
            "http://tupian.qqjay.com/u/2012/1222/9_234739_3.jpg",
            "http://tupian.qqjay.com/u/2012/1222/9_234739_6.jpg",
            "http://tupian.qqjay.com/u/2012/1222/9_234739_8.jpg",
            "http://tupian.qqjay.com/u/2012/1222/1_234832_5.jpg",
            "http://tupian.qqjay.com/u/2012/1222/1_234832_11.jpg",
            "http://tupian.qqjay.com/u/2012/1222/1_234832_13.jpg",
            "http://tupian.qqjay.com/u/2012/1222/1_234832_8.jpg",
            "http://tupian.qqjay.com/u/2012/1222/1_234832_4.jpg"};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        initData();//初始化数据
        // initList();//加载listview条目
        // initGridView();//加载gridleview条目
        initStrings();

    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        picList = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
        for (int i = 0; i < str.length; i++) {
            picList.add(new DataBean(str[i], "第" + i + "个图片"));
        }
    }

    //加载listview条目
    public void initList() {

        // Recycle中的ListView比我们平时的ListView还要强大
        // 可以垂直滑动，可以水平滑动。两种情况
        // 还可以反向加载-->
        // 设置布局布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        //实例化适配器
        HomeAdapter mAdapter = new HomeAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);//添加适配器
    }


    public void initGridView() {
        // 参数二，item分割数量，
        // 可以垂直滑动，可以水平滑动。两种情况
        // 还可以反向加载-->
        // 设置布局布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL_LIST));
        mRecyclerView.setAdapter(new HomeAdapter(this, mDatas));//添加适配器
    }

    //瀑布流
    public void initStrings() {
        // 设置布局布局管理器
        StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggered);
        mRecyclerView.setAdapter(new StaggeredAdp(this, picList));//添加适配器

    }


}

