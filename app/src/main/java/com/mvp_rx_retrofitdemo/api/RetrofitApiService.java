package com.mvp_rx_retrofitdemo.api;

import com.mvp_rx_retrofitdemo.bean.WeatherInfoBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 描述：
 * 作者：dc on 2017/4/15 11:34
 * 邮箱：597210600@qq.com
 */
public interface RetrofitApiService {

    //请求的接口地址：http://api.avatardata.cn/Weather/Query?key=75bfe88f27a34311a41591291b7191ce&cityname=%E9%95%BF%E6%B2%99
    @GET("Weather/Query?")
    Observable<WeatherInfoBean> getLoadWeatherInfo(@Query("key") String key, @Query("cityname") String cityname);
}
