package com.exam.jiang.day0901property;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class propertyValuesHolder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_values_holder);
    }
    public void rotateyAnimRun(View view)
    {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
            0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ1 = PropertyValuesHolder.ofFloat("rotationX",  0.0F, 360.0F);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ,pvhZ1).setDuration(3000).start();
    }
}
