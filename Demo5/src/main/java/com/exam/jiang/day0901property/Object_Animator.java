package com.exam.jiang.day0901property;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class Object_Animator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

    }
    public void rotateyAnimRun(View view)
    {
//        animator.setDuration(2000);//动画时间
//
//        animator.setInterpolator(new BounceInterpolator());//动画插值
//
//        animator.setRepeatCount(-1);//设置动画重复次数
//
//        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
//
//        animator.setStartDelay(1000);//动画延时执行

//        ObjectAnimator
//                .ofFloat(view, "rotationX", 0.0F, 360.0F)//
//
//                .setDuration(500)//
//                .start();
//

//     ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationX",  0.0F, 360.0F);
//
//        animator.setDuration(2500).start();


//        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.5f);
//
//        animator.setDuration(2000).start();
//        after(Animator anim) 将现有动画插入到传入的动画之后执行
//        after(long delay) 将现有动画延迟指定毫秒后执行
//        before(Animator anim) 将现有动画插入到传入的动画之前执行
//        with(Animator anim) 将现有动画和传入的动画同时执行
         ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 200.0f, 0f);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view,  "scaleX", 1.0f, 2.0f,1.0f);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, 360f);


        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.2f, 1.0F);


        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animator1).with(animator2);
        animSet.play(animator2).with(animator3);
        animSet.play(animator4).after(animator3);
        animSet.setDuration(3000);
        animSet.start();
    }

    public void Butt(final View view)
    {
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "width", 1000);
        animator .setDuration(5000).start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ViewGroup parent = (ViewGroup) view.getParent();
                if (parent != null){
                    parent.removeView(view);
            }
            }

            @Override
            public void onAnimationCancel(Animator animation) {


            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

}
