package cn.studyjamscn.s1.sj30.liangyinghao.database;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.studyjamscn.s1.sj30.liangyinghao.R;

/**
 * 美图数据
 * Created by Administrator on 2016/4/29 0029.
 */
public class FoodData {
    private ArrayList<Integer> mArrayList;

    public List<Integer> getData(Context context){
        mArrayList = new ArrayList<Integer>();
        mArrayList.add(R.drawable.food_1);
        mArrayList.add(R.drawable.food_2);
        mArrayList.add(R.drawable.food_3);
        mArrayList.add(R.drawable.food_4);
        mArrayList.add(R.drawable.food_5);
        mArrayList.add(R.drawable.food_6);
        mArrayList.add(R.drawable.food_7);
        mArrayList.add(R.drawable.food_8);
        mArrayList.add(R.drawable.food_9);
        mArrayList.add(R.drawable.food_10);
        mArrayList.add(R.drawable.food_11);
        mArrayList.add(R.drawable.food_12);
        mArrayList.add(R.drawable.food_13);
        mArrayList.add(R.drawable.food_14);
        mArrayList.add(R.drawable.food_15);
        mArrayList.add(R.drawable.food_16);
        return mArrayList;
    }
}
