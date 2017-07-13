package com.lee.leemvp.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lee.leemvp.contracts.ScanPicContract;
import com.lee.leemvp.network.ApiServiceManager;
import com.lee.leemvp.network.MeizhiData;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by android on 2016/11/28.
 */
public class ScanPicPresenter implements ScanPicContract.Presenter {

    private final ScanPicContract.View mView;
    private Context context;

    public ScanPicPresenter(Context context, ScanPicContract.View mView) {
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void loadingData() {
        Call<MeizhiData> call = ApiServiceManager.getInstance().getMeizhiApi().getMeizhi(1);
        call.enqueue(callback);
    }

    public Callback<MeizhiData> callback = new Callback<MeizhiData>() {
        @Override
        public void onResponse(Call<MeizhiData> call, Response<MeizhiData> response) {


            Glide.with(context).pauseRequests();

            PhotoViewAttacher mAttacher;
            LinkedList<ImageView> imageViews = new LinkedList<>();
            for (int i = 0; i < response.body().getResults().size(); i++) {
                ImageView imageView = new ImageView(context);
                Glide.with(context)
                        .load(response.body().getResults().get(i).getUrl())
                        .dontAnimate()
                        .into(imageView);
                mAttacher = new PhotoViewAttacher(imageView);
                mAttacher.update();
                imageViews.add(imageView);
            }

            mView.showPic(imageViews);
        }

        @Override
        public void onFailure(Call<MeizhiData> call, Throwable t) {

        }
    };

}
