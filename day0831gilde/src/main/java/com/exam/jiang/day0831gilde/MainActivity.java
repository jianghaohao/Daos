package com.exam.jiang.day0831gilde;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView picasso_img;
    private ImageView glide_img;
    private ImageView glide_gif;
    private ImageView picasso_gif;
    private Button pCache;
    private Button gCache;
    private static final String PICASSO_CACHE = "picasso-cache";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      initData();
//        initEvent();

        //Picasso加载图片
        Picasso.with(MainActivity.this)
                .load("http://img3.duitang.com/uploads/item/201508/18/20150818220524_YusAz.jpeg")
                //指定加载图片的大小
                .resize(300,300)
                //计算ImageView的真实大小
//                .fit()
                .centerCrop()
                //加载中
                .placeholder(R.mipmap.ic_launcher)
                //加载失败
                .error(R.drawable.error)
                .into(picasso_img);
    }
    private void initData() {
        glide_img = (ImageView) findViewById(R.id.glide_img);
        picasso_img = (ImageView) findViewById(R.id.picasso_img);

        glide_gif = (ImageView) findViewById(R.id.glide_gif);
        picasso_gif = (ImageView) findViewById(R.id.picasso_gif);

        pCache = (Button) findViewById(R.id.pCache);
        gCache = (Button) findViewById(R.id.gCache);

        pCache.setOnClickListener(MainActivity.this);
        gCache.setOnClickListener(MainActivity.this);

    }

    private void initEvent() {

        //Picasso加载图片
        Picasso.with(MainActivity.this)
                .load("http://img3.duitang.com/uploads/item/201508/18/20150818220524_YusAz.jpeg")
                //指定加载图片的大小
             .resize(300,300)
                //计算ImageView的真实大小
//                .fit()
//                .centerCrop()
                //加载中
                .placeholder(R.mipmap.ic_launcher)
                //加载失败
                .error(R.drawable.error)
                .into(picasso_img);
        //Picasso加载动图
//        Picasso.with(MainActivity.this)
//                .load("http://b.hiphotos.baidu.com/zhidao/pic/item/d31b0ef41bd5ad6e141a5b5682cb39dbb7fd3cae.jpg")
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.drawable.error)
//                .transform(new Transformation() {
//
//
//                    public Bitmap transform(Bitmap source) {
//                        int size = Math.min(source.getWidth(), source.getHeight());
//                        int x = (source.getWidth() - size) / 2;
//                        int y = (source.getHeight() - size) / 2;
//                        Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
//                        if (result != source) {
//                            source.recycle();
//                        }
//                        return result;
//                    }
//
//
//                    public String key() {
//                        // TODO Auto-generated method stub
//                        return "square()";
//                    }
//                })
//                .into(picasso_gif);
        //Glide加载图片
        Glide.with(MainActivity.this)
                .load("http://scimg.jb51.net/allimg/160716/105-160G61F250436.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.error)
                .animate(R.anim.sett)
                //.skipMemoryCache(true)//跳过内存缓存
                //.diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存最终图片,默认为所有版本(原图，修改后的)
                //.thumbnail(0.1f)//缩略图，为原图的10%大小
                //.crossFade(1000) //淡入淡出动画
              .centerCrop()//进行裁剪，设置中心裁剪
                //.override(1920,1678)//最终显示的图片的像素，不是宽高
                .into(glide_img);

        //Glide加载动图
        Glide.with(MainActivity.this)
                .load("http://b.hiphotos.baidu.com/zhidao/pic/item/d31b0ef41bd5ad6e141a5b5682cb39dbb7fd3cae.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.error)
                .into(glide_gif);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pCache:
                Toast.makeText(MainActivity.this, "清除Picasso缓存", Toast.LENGTH_SHORT).show();
                File cacheFile = new File(getApplicationContext().getCacheDir(), PRINT_SERVICE);
                Log.i("TAG", "========" + cacheFile.toString());
                // Picasso.with(MainActivity.this).invalidate((data.get(pos).getFeed_thumb_image()).memoryPolicy(MemoryPolicy.NO_CACHE));
//            Picasso.with(MainActivity.this).invalidate(cacheFile);
                break;
            case R.id.gCache:
                Toast.makeText(MainActivity.this, "清除Glide缓存", Toast.LENGTH_SHORT).show();
                /** 子线程运行 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(getApplicationContext()).clearDiskCache();
                    }
                }).start();
                Glide.get(this).clearMemory();//只能在主线程运行

                break;
        }
    }
}
