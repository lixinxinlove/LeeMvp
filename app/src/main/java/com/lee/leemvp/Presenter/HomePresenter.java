package com.lee.leemvp.Presenter;

import android.os.Handler;
import android.os.Message;

import com.lee.leemvp.contracts.HomeContract;
import com.lee.leemvp.model.UserEntity;

/**
 * Created by android on 2016/11/25.
 */
public class HomePresenter implements HomeContract.Presenter {


    private final HomeContract.View homeView;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            UserEntity userEntity = (UserEntity) msg.obj;
            if (userEntity.userName.equals("lee") && userEntity.password.equals("123")) {
                homeView.setText("登录成功");
            } else {
                homeView.setText("登录失败");
            }
            homeView.showProgress(false);
        }
    };


    public HomePresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        homeView.setPresenter(this);
    }

    @Override
    public void start() {
        homeView.showProgress(false);
    }

    @Override
    public void login(UserEntity userEntity) {

        homeView.showProgress(true);
        Message msg = new Message();
        msg.what = 1;
        msg.obj = userEntity;
        handler.sendMessageDelayed(msg, 4000);


    }
}
