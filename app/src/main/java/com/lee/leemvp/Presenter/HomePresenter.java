package com.lee.leemvp.presenter;

import com.lee.leemvp.contracts.HomeContract;
import com.lee.leemvp.model.UserEntity;
import com.lee.leemvp.network.ApiServiceManager;
import com.lee.leemvp.network.MeizhiData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by android on 2016/11/25.
 */
public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View homeView;

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

        Call<MeizhiData> call = ApiServiceManager.getInstance().getMeizhiApi().getMeizhi(1);
        call.enqueue(callback);
        homeView.showProgress(true);

    }

    Callback<MeizhiData> callback = new Callback<MeizhiData>() {

        @Override
        public void onResponse(Call<MeizhiData> call, Response<MeizhiData> response) {

            homeView.setText(response.body().getResults().get(0).getUrl());
            homeView.showProgress(false);
        }

        @Override
        public void onFailure(Call<MeizhiData> call, Throwable t) {
            homeView.setText("登录失败");
            homeView.showProgress(false);
        }
    };

}
