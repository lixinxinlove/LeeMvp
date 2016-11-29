package com.lee.leemvp.contracts;

import android.widget.ImageView;

import com.lee.leemvp.base.BasePresenter;
import com.lee.leemvp.base.BaseView;

import java.util.LinkedList;

/**
 * Created by android on 2016/11/28.
 */
public interface ScanPicContract {

    interface View extends BaseView<Presenter>{

        void showProgress(boolean flag);

        void showPic(LinkedList<ImageView> data);
    }

    interface Presenter extends BasePresenter{

        void loadingData();

    }

}
