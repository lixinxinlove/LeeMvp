package com.lee.leemvp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by android on 2016/11/30.
 * 圆形图片
 */
public class CircleImageView extends ImageView {
    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        //获得图片的宽度
        int width = getWidth();
        //获得图片的高度
        int height = getHeight();
        //短的二分之一作为半径
        int radius = height > width ? width / 2 : height / 2;

        radius -= 10;
        //重新定义的一个画布，这一步很关键
        Paint mPaint = new Paint();
        //抗锯齿
        mPaint.setAntiAlias(true);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas bitmapCanvas = new Canvas(bitmap);

        super.onDraw(bitmapCanvas);

        //圆形的框
        Bitmap cB = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas cCanv = new Canvas(cB);
        //在控件中间画一个
        cCanv.drawCircle(width / 2, height / 2, radius, mPaint);

        canvas.drawBitmap(bitmap, 0.0f, 0.0f, mPaint);
        //dst是后画的图形
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        //一定要用之前的画布，不然会出现边角是黑色
        bitmapCanvas.drawBitmap(cB, 0.0f, 0.0f, mPaint);

        //给图形加边框
        Paint paint =new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width/ 2, height/ 2, radius, paint);



        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawRoundRect(0,0,width,height, 30, 30, paint);

    }
}
