package cn.studyjamscn.s1.sj30.liangyinghao.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.studyjamscn.s1.sj30.liangyinghao.R;
import cn.studyjamscn.s1.sj30.liangyinghao.fragment.FoodFrg;
import cn.studyjamscn.s1.sj30.liangyinghao.fragment.GameFrg;
import cn.studyjamscn.s1.sj30.liangyinghao.fragment.PhotoFrg;

public class MainAct extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitleList = new ArrayList<>();//标题集合
    private List<Fragment> mFragments = new ArrayList<>();//fragment集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.act_main);
        initView();//初始化控件
        initData();//初始化数据
        initEvent();//初始化事件
    }

    private void initEvent() {
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());//点击tab时切换ViewPager，如果不加这一句的话滑动ViewPager底部tab可以切换，但是点击tab而ViewPager不会切换。
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。如果设置了ViewPager，那么ViewPagerAdapter中的getPageTitle()方法返回的就是Tab上的标题
    }

    private void initData() {
        GameFrg gameFrg = new GameFrg();
        PhotoFrg photoFrg = new PhotoFrg();
        FoodFrg foodFrg = new FoodFrg();
       // MusicFrg musicFrg = new MusicFrg();
        mFragments.add(gameFrg);
        mFragments.add(photoFrg);
        mFragments.add(foodFrg);
       // mFragments.add(musicFrg);

        //添加页卡标题
        mTitleList.add("游戏");
        mTitleList.add("美图");
        mTitleList.add("美食");
        //mTitleList.add("音乐");

        //mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        //mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    //ViewPager适配器
    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mTitleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }
    }
}