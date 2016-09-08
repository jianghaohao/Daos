package com.exam.jiang.day0901property;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class Value_Animator extends AppCompatActivity {

protected static final String TAG = "TAG";

    private ImageView mBlueBall;

    private float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_value__animator);

        mBlueBall = (ImageView) findViewById(R.id.id_ball);

        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;

    }

    /**
     * 自由落体
     *
     * @param view
     */
    public void verticalRun(View view)
    {
        ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight
                - mBlueBall.getHeight()-500);
        animator.setTarget(mBlueBall);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setDuration(3000).start();
        // animator.setInterpolator(value)
        //自己设置属性的更新
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                mBlueBall.setTranslationY((Float) animation.getAnimatedValue());

        }
        });
    }
    public void paoa(View view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue)
            {
                Log.e(TAG, fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * g * t (g = 100px / s*s)
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 100 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new  ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                mBlueBall.setX(point.x);
                mBlueBall.setY(point.y);

            }
        });
    }
    /**
     *
     *
     * @param view
     */
    public void paowuxian(View view)
    {
//
//        ValueAnimator valueAnimator = new ValueAnimator();
//        valueAnimator.setDuration(3000);
//        valueAnimator.setObjectValues(new PointF(0, 0));
//        valueAnimator.setInterpolator(new LinearInterpolator());
//        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
//        {
//            // fraction = t / duration
//            @Override
//            public PointF evaluate(float fraction, PointF startValue,
//                                   PointF endValue)
//            {
//                Log.e(TAG, fraction * 3 + "");
//                // x方向200px/s ，则y方向0.5 * g * t (g = 100px / s*s)
//                PointF point = new PointF();
//                point.x = 200 * fraction * 3;
//                point.y = 0.5f * 100 * (fraction * 3) * (fraction * 3);
//                return point;
//            }
//        });
//
//        valueAnimator.start();
//        valueAnimator.addUpdateListener(new  ValueAnimator.AnimatorUpdateListener()
//        {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation)
//            {
//                PointF point = (PointF) animation.getAnimatedValue();
//                mBlueBall.setX(point.x);
//                mBlueBall.setY(point.y);
//
//            }
//        });
        ObjectAnimator yBouncer = ObjectAnimator.ofFloat(mBlueBall, "y",
                mBlueBall.getY(), mScreenHeight-500);
        yBouncer.setDuration(1500);
        // 设置插值器(用于调节动画执行过程的速度)
        yBouncer.setInterpolator(new BounceInterpolator());
        // 设置重复次数(缺省为0,表示不重复执行)
        yBouncer.setRepeatCount(1);
        // 设置重复模式(RESTART或REVERSE),重复次数大于0或INFINITE生效
        yBouncer.setRepeatMode(ValueAnimator.REVERSE);
        // 设置动画开始的延时时间(200ms)
        yBouncer.setStartDelay(200);
        // 开始动画
        yBouncer.start();
    }

    public void fadeOut(View view)
    {
        ObjectAnimator anim = ObjectAnimator.ofFloat(mBlueBall, "alpha", 0.5f);

        anim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                Log.e(TAG, "onAnimationEnd");
                ViewGroup parent = (ViewGroup) mBlueBall.getParent();
                if (parent != null)
                    parent.removeView(mBlueBall);
            }
        });

        anim.addListener(new  ValueAnimator.AnimatorListener()
        {


            public void onAnimationStart(Animator animation)
            {
                Log.e(TAG, "onAnimationStart");
            }


            public void onAnimationRepeat(Animator animation)
            {
                // TODO Auto-generated method stub
                Log.e(TAG, "onAnimationRepeat");
            }


            public void onAnimationEnd(Animator animation)
            {
                Log.e(TAG, "onAnimationEnd");
                ViewGroup parent = (ViewGroup) mBlueBall.getParent();
                if (parent != null)
                    parent.removeView(mBlueBall);
            }

            @Override
            public void onAnimationCancel(Animator animation)
            {
                // TODO Auto-generated method stub
                Log.e(TAG, "onAnimationCancel");
            }
        });
        anim.start();
    }

    public void onClick(View view)
    {
    }
}
