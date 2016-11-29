package com.lee.leemvp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android on 2016/11/25.
 */
public class ApiServiceManager {


    private static ApiServiceManager instance = new ApiServiceManager();

    public static ApiServiceManager getInstance() {
        return instance;
    }

    private MeizhiApi meizhiApi;


    private ApiServiceManager(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")//设置基础url
                .addConverterFactory(GsonConverterFactory.create());//Gson转换器直接返回对象

        Retrofit retrofit = builder.build();
        meizhiApi = retrofit.create(MeizhiApi.class);
    }


    public MeizhiApi getMeizhiApi(){
        return meizhiApi;
    }



}
