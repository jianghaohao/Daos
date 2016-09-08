package cn.studyjamscn.s1.sj30.liangyinghao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.studyjamscn.s1.sj30.liangyinghao.R;

/**
 * 游戏人物技巧界面
 * Created by Administrator on 2016/4/28 0028.
 */
public class GameTrickAct extends AppCompatActivity {
    private TextView txt_trick;
    private TextView txt_title;
    private String trick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.act_gametrick);
        Intent intent = getIntent();
        trick = intent.getStringExtra("trick"); //从GameDetailAct中获得数据
        initView();//初始化控件
        initEvent();//初始化事件
    }

    private void initEvent() {
        txt_trick.setText(trick);
        txt_title.setText("使用技巧");
    }

    private void initView() {
        txt_trick = (TextView) findViewById(R.id.gametrickact_txt_trick);
        txt_title = (TextView) findViewById(R.id.txt_title);
    }
}
