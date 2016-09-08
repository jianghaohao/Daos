package cn.studyjamscn.s1.sj30.liangyinghao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.studyjamscn.s1.sj30.liangyinghao.R;
import cn.studyjamscn.s1.sj30.liangyinghao.module.GameItemDetail;

/**
 * 游戏详情界面
 * Created by Administrator on 2016/4/27 0027.
 */
public class GameDetailAct extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout relativeLayout;
    private Button btn_background;
    private Button btn_skill;
    private Button btn_trick;
    private TextView txt_title;
    private GameItemDetail data;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.act_gamedetail);
        Intent intent = getIntent();
        data = (GameItemDetail) intent.getSerializableExtra("detail");//从上一个fragment中获得数据
        initView();//初始化控件
        initEvent();//初始化事件
    }

    private void initEvent() {
        relativeLayout.setBackgroundResource(data.getPicture());
        btn_background.setOnClickListener(this);
        btn_skill.setOnClickListener(this);
        btn_trick.setOnClickListener(this);
        txt_title.setText(data.getName());
    }

    private void initView() {
        relativeLayout = (RelativeLayout) findViewById(R.id.gdact_relativelayout);
        btn_background = (Button) findViewById(R.id.gdact_btn_background);
        btn_skill = (Button) findViewById(R.id.gdact_btn_skill);
        btn_trick = (Button) findViewById(R.id.gdact_btn_trick);
        txt_title = (TextView) findViewById(R.id.txt_title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gdact_btn_background:
                intent = new Intent(GameDetailAct.this, GameBackgroundAct.class);
                intent.putExtra("background", data.getBackground());
                //intent.putExtra("picture",data.getPicture());
                startActivity(intent);
                break;
            case R.id.gdact_btn_skill:
                intent = new Intent(GameDetailAct.this, GameSkillAct.class);
                intent.putExtra("skill", data.getSkill());
                startActivity(intent);
                break;
            case R.id.gdact_btn_trick:
                intent = new Intent(GameDetailAct.this, GameTrickAct.class);
                intent.putExtra("trick", data.getTrick());
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
