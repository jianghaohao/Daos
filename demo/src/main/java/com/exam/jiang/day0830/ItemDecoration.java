package com.exam.jiang.day0830;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jianghao on 2016/8/30.
 */
public  abstract class ItemDecoration {

    public void onDraw(Canvas c, RecyclerView parent,RecyclerView.State state) {
        onDraw(c, parent);
    }

    @Deprecated
    public void onDraw(Canvas c, RecyclerView parent) {
    }

    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        onDrawOver(c, parent);
    }

    @Deprecated
    public void onDrawOver(Canvas c, RecyclerView parent) {
    }

    @Deprecated
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        outRect.set(0, 0, 0, 0);
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


        getItemOffsets(outRect, ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewPosition(),
                parent);
    }
}