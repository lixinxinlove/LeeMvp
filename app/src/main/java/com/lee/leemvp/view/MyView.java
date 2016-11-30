package com.lee.leemvp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.lee.leemvp.R;

/**
 * Created by android on 2016/11/30.
 */
public class MyView extends View {


    private Bitmap bitmap1;
    private Bitmap bitmap2;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.pic1);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.pic2);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint mPaint = new Paint();

        Bitmap bitmap=createCircleImage(bitmap1,500);

        mPaint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
       // mPaint.reset();
        // canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2-5,mPaint);
       // mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

       // mPaint.setStyle(Paint.Style.STROKE);
       // mPaint.setColor(Color.WHITE);
      //  canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 5, mPaint);

    }


    private Bitmap createCircleImage(Bitmap source, int min)
    {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        /**
         * 产生一个同样大小的画布
         */
        Canvas canvas = new Canvas(target);
        /**
         * 首先绘制圆形
         */
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        /**
         * 使用SRC_IN
         */
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        /**
         * 绘制图片
         */
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }
}
