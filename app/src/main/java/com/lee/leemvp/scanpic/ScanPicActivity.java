package com.lee.leemvp.scanpic;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lee.leemvp.presenter.ScanPicPresenter;
import com.lee.leemvp.R;
import com.lee.leemvp.base.BaseActivity;
import com.lee.leemvp.contracts.ScanPicContract;

import java.util.LinkedList;

public class ScanPicActivity extends BaseActivity implements ScanPicContract.View {


    private ScanPicContract.Presenter mPresenter;

    private ViewPager viewPager;

    private MyPagerAdapter adapter;

    @Override
    public int LayoutId() {
        return R.layout.activity_scan_pic;
    }

    @Override
    public void findView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    @Override
    public void setListener4View() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ScanPicPresenter(this,this);

        mPresenter.loadingData();

    }

    @Override
    public void showProgress(boolean flag) {

    }

    @Override
    public void showPic(LinkedList<ImageView> data) {
        Glide.with(this).resumeRequests();
        adapter=new MyPagerAdapter(data);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void setPresenter(ScanPicContract.Presenter presenter) {
        mPresenter = presenter;
    }

    class MyPagerAdapter extends PagerAdapter {

        private LinkedList<ImageView> images;

        public MyPagerAdapter(LinkedList<ImageView> images) {
            this.images = images;
        }


        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(images.get(position));
            return images.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(images.get(position));
        }
    }

}
