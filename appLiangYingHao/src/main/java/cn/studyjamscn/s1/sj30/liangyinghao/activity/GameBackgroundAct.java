package cn.studyjamscn.s1.sj30.liangyinghao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.studyjamscn.s1.sj30.liangyinghao.R;

/**
 * 游戏人物背景界面
 * Created by Administrator on 2016/4/28 0028.
 */
public class GameBackgroundAct extends AppCompatActivity {
    //private LinearLayout linearLayout;
    private TextView txt_background;
    private TextView txt_title;
    private String background;
    //private int picture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.act_gamebackground);
        Intent intent = getIntent();
        background = intent.getStringExtra("background"); //从GameDetailAct中获得数据
        //picture =intent.getIntExtra("picture",R.drawable.qitiandasheng);
        initView();//初始化控件
        initEvent();//初始化事件
    }

    private void initEvent() {
        //linearLayout.setBackgroundResource(picture);
        txt_background.setText(background);
        txt_title.setText("人物背景");
    }

    private void initView() {
        //linearLayout = (LinearLayout) findViewById(R.id.act_gamebackground_linearlayout);
        txt_background = (TextView) findViewById(R.id.gamebackgroundact_txt_background);
        txt_title = (TextView) findViewById(R.id.txt_title);
    }
}
