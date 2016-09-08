package cn.studyjamscn.s1.sj30.liangyinghao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.studyjamscn.s1.sj30.liangyinghao.R;
import cn.studyjamscn.s1.sj30.liangyinghao.adapter.FoodFrgAdapter;
import cn.studyjamscn.s1.sj30.liangyinghao.database.FoodData;

/**
 * 美食界面，使用gridview效果的recycleView
 * Created by Administrator on 2016/4/27 0027.
 */
public class FoodFrg extends Fragment {
    private RecyclerView mRecyclerView;
    private FoodFrgAdapter mAdapter;
    private ArrayList<Integer> mArrayList;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food, container, false);
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
        GridLayoutManager layoutManager =new GridLayoutManager(getActivity(),3);//3行
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);//水平
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mArrayList = (ArrayList<Integer>) new FoodData().getData(getContext());
        mAdapter = new FoodFrgAdapter(getActivity(), mArrayList);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.foodFrg_recycleView);
    }
}
