package cn.studyjamscn.s1.sj30.liangyinghao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.studyjamscn.s1.sj30.liangyinghao.R;
import cn.studyjamscn.s1.sj30.liangyinghao.activity.GameDetailAct;
import cn.studyjamscn.s1.sj30.liangyinghao.adapter.GameFrgAdapter;
import cn.studyjamscn.s1.sj30.liangyinghao.database.GameData;
import cn.studyjamscn.s1.sj30.liangyinghao.module.GameItemDetail;

/**
 * 游戏界面
 * Created by Administrator on 2016/4/24 0024.
 */
public class GameFrg extends Fragment implements GameFrgAdapter.OnRecyclerViewItemClickListener {
    private RecyclerView mRecyclerView;
    private GameFrgAdapter mAdapter;
    private ArrayList<GameItemDetail> mArrayList;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_game, container, false);
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
        mRecyclerView.setHasFixedSize(true);//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());//可以设置滚动的方向，默认竖直滚动
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.gameFrg_recycleView);
    }

    private void initData() {
        mArrayList = (ArrayList<GameItemDetail>) new GameData().getData(getContext());
        mAdapter = new GameFrgAdapter(getActivity(), mArrayList);
    }

    //recycleView点击事件
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), GameDetailAct.class);
        intent.putExtra("detail", mArrayList.get(position));
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        //Toast.makeText(getActivity(), "long click：" + position, Toast.LENGTH_SHORT).show();
    }
}