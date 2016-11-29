package com.lee.leemvp;

import android.content.Context;
import android.os.Handler;

/**
 * Created by android on 2016/11/28.
 */
public class MyRunnable implements Runnable {

    private Context context;
    private Handler handler;

    public MyRunnable(Context context, Handler handler){
        this.context=context;
        this.handler=handler;
    }

    @Override
    public void run() {
        handler.sendEmptyMessageDelayed(1,5000);
        handler.sendEmptyMessageDelayed(2,7000);
        handler.sendEmptyMessageDelayed(3,9000);
    }
}
