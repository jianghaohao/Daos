package com.exam.jiang.day0901property;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button)findViewById(R.id.b1);
        Button b11=(Button)findViewById(R.id.b11);

        Button b2=(Button)findViewById(R.id.b2);
//        Button b3=(Button)findViewById(R.id.b3);
        Button b4=(Button)findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b11.setOnClickListener(this);

        b2.setOnClickListener(this);
//        b3.setOnClickListener(this);
        b4.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.b1:
                Intent Intent1=new Intent(MainActivity.this,Object_Animator.class);
                startActivity(Intent1);
                break;
            case R.id.b11:
                Intent Intent11=new Intent(MainActivity.this,propertyValuesHolder.class);
                startActivity(Intent11);
                break;
            case R.id.b2:
                Intent Intent2=new Intent(MainActivity.this,Value_Animator.class);
                startActivity(Intent2);
                break;
//            case R.id.b3:
//                break;
            case R.id.b4:
                Intent Intent4=new Intent(MainActivity.this,LayoutAnimaActivity.class);
                startActivity(Intent4);
                break;



        }
    }
}
