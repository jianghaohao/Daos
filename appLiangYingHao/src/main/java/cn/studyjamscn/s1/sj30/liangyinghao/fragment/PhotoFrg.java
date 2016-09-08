package cn.studyjamscn.s1.sj30.liangyinghao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.studyjamscn.s1.sj30.liangyinghao.R;
import cn.studyjamscn.s1.sj30.liangyinghao.adapter.PhotoFrgAdapter;
import cn.studyjamscn.s1.sj30.liangyinghao.database.PhotoData;

/**
 * 美图界面,使用瀑布流的recycleView
 * Created by Administrator on 2016/4/27 0027.
 */
public class PhotoFrg extends Fragment {
    private RecyclerView mRecyclerView;
    private PhotoFrgAdapter mAdapter;
    private ArrayList<Integer> mArrayList;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photo, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();//初始化控件
        initData();//初始化数据
        initEvent();//初始化事件
    }

    private void initEvent() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);//表示2列，并且是竖直方向的瀑布流
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mArrayList = (ArrayList<Integer>) new PhotoData().getData(getContext());
        mAdapter = new PhotoFrgAdapter(getActivity(), mArrayList);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.photoFrg_recycleView);
    }
}
