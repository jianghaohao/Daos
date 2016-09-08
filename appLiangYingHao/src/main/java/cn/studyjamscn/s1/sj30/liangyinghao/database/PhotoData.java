package cn.studyjamscn.s1.sj30.liangyinghao.database;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.studyjamscn.s1.sj30.liangyinghao.R;

/**
 * 美图数据
 * Created by Administrator on 2016/4/29 0029.
 */
public class PhotoData {
    private ArrayList<Integer> mArrayList;

    public List<Integer> getData(Context context){
        mArrayList = new ArrayList<Integer>();
        mArrayList.add(R.drawable.photo_zhixiao);
        mArrayList.add(R.drawable.photo_songzhixiao);
        mArrayList.add(R.drawable.photo_anglebaby);
        mArrayList.add(R.drawable.photo_huge);
        mArrayList.add(R.drawable.photo_xiaonvhai);
        mArrayList.add(R.drawable.photo_qingxin);
        mArrayList.add(R.drawable.photo_meinv);
        mArrayList.add(R.drawable.photo_liqin);
        mArrayList.add(R.drawable.photo_bijini);
        mArrayList.add(R.drawable.photo_liuyan);
        mArrayList.add(R.drawable.photo_anglebaby);
        return mArrayList;
    }
}
