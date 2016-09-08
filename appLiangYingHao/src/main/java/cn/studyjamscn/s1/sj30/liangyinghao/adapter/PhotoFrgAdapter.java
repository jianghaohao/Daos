package cn.studyjamscn.s1.sj30.liangyinghao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import cn.studyjamscn.s1.sj30.liangyinghao.R;

/**
 * 美图recycleView的Adapter
 * Created by Administrator on 2016/4/29 0029.
 */
public class PhotoFrgAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private Context mContext;
    private ArrayList<Integer> mArrayList;

    public PhotoFrgAdapter(Context context, ArrayList<Integer> ArrayList) {
        this.mContext = context;
        this.mArrayList = ArrayList;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.recycleview_photo_item,null);
        PhotoViewHolder viewHolder = new PhotoViewHolder(view);
        return viewHolder;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.mPic.setImageResource(mArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}

//自定义的ViewHolder，持有每个Item的的所有界面元素
class PhotoViewHolder extends RecyclerView.ViewHolder {
    ImageView mPic;

    public PhotoViewHolder(View view) {
        super(view);
        mPic = (ImageView) view.findViewById(R.id.photoFrg_img_pic);
    }
}