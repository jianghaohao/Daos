package cn.studyjamscn.s1.sj30.liangyinghao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.studyjamscn.s1.sj30.liangyinghao.R;

/**
 * 游戏人物技能界面
 * Created by Administrator on 2016/4/28 0028.
 */
public class GameSkillAct extends AppCompatActivity {
    private TextView txt_skill;
    private TextView txt_title;
    private String skill;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.act_gameskill);
        Intent intent = getIntent();
        skill = intent.getStringExtra("skill"); //从GameDetailAct中获得数据
        initView();//初始化控件
        initEvent();//初始化事件
    }

    private void initEvent() {
        txt_skill.setText(skill);
        txt_title.setText("人物技能");
    }

    private void initView() {
        txt_skill = (TextView) findViewById(R.id.gameskillact_txt_skill);
        txt_title = (TextView) findViewById(R.id.txt_title);
    }
}
