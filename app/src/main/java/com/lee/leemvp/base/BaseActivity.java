package com.lee.leemvp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.view.View.OnClickListener;

/**
 * Created by android on 2016/11/25.
 */
public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {
    @LayoutRes
    public abstract int LayoutId();

    public abstract void findView();

    public abstract void setListener4View();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        findView();
        setListener4View();
    }

    @Override
    public void onClick(View view) {

    }
}
