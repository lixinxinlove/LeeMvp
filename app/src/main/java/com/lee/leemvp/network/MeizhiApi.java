package com.lee.leemvp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by android on 2016/11/28.
 */
public interface MeizhiApi {

    @GET("data/福利/10/{day}")//()里面的是相对路径，当然绝对路径也是可以的
    Call<MeizhiData> getMeizhi(@Path("day") int day);//{}里面的是要替换的内容 用注解@Path映射


}
