package com.exam.jiang.day0901recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghaihua on 2016/9/1.
 */
public class StaggeredAdp extends RecyclerView.Adapter<StaggeredAdp.StaViewHoder> {
    private Context context;
    private List<DataBean> list = new ArrayList<>();

    public StaggeredAdp(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public StaViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        StaViewHoder staViewHoder = new StaViewHoder(View.inflate(context, R.layout.stagered_item, null));
        return staViewHoder;
    }

    @Override
    public void onBindViewHolder(StaViewHoder holder, int position) {
        holder.setData(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StaViewHoder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;


        public StaViewHoder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.stag_iv);
            tv = (TextView) itemView.findViewById(R.id.stag_tv);
        }

        public void setData(DataBean data) {
//            System.out.println("data.incon               " + data.incon);
            Picasso.with(context).load(data.incon).error(R.mipmap.ic_launcher)
                    .into(iv);//加载图片
            tv.setText(data.content);
        }
    }
}
