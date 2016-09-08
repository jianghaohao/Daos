package cn.studyjamscn.s1.sj30.liangyinghao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.studyjamscn.s1.sj30.liangyinghao.R;
import cn.studyjamscn.s1.sj30.liangyinghao.module.GameItemDetail;

/**
 * Created by Administrator on 2016/4/24 0024.
 * 游戏界面RecycleView的Adapter
 */
public class GameFrgAdapter extends RecyclerView.Adapter<GameViewHolder> {
    private Context mContext;
    private ArrayList<GameItemDetail> mArrayList;

    public GameFrgAdapter(Context context, ArrayList<GameItemDetail> ArrayList) {
        this.mContext = context;
        this.mArrayList = ArrayList;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.recycleview_game_item,null);//这样写宽是wrap_content
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_game_item, parent, false);
        GameViewHolder viewHolder = new GameViewHolder(view);
        return viewHolder;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final GameViewHolder holder, final int position) {
        holder.mAvatar.setImageResource(mArrayList.get(position).getAvatar());
        holder.mName.setText(mArrayList.get(position).getName());
        holder.mType.setText(mArrayList.get(position).getType());

        //点击事件回调
        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }
            });

            //longClick
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });
        }
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

}

//自定义的ViewHolder，持有每个Item的的所有界面元素
class GameViewHolder extends RecyclerView.ViewHolder {
    ImageView mAvatar;
    TextView mName;
    TextView mType;

    public GameViewHolder(View view) {
        super(view);
        mAvatar = (ImageView) view.findViewById(R.id.gameFrg_img_avatar);
        mName = (TextView) view.findViewById(R.id.gameFrg_txt_name);
        mType = (TextView) view.findViewById(R.id.gameFrg_txt_type);
    }
}