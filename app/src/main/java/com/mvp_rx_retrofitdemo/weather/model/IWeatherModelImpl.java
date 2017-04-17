package com.mvp_rx_retrofitdemo.weather.model;


import android.content.Context;
import android.util.Log;

import com.mvp_rx_retrofitdemo.api.RetrofitApiService;
import com.mvp_rx_retrofitdemo.base.BaseModel;
import com.mvp_rx_retrofitdemo.base.IBaseRequestCallBack;
import com.mvp_rx_retrofitdemo.bean.WeatherInfoBean;
import com.mvp_rx_retrofitdemo.helper.ProgressSubscriber;
import com.mvp_rx_retrofitdemo.helper.SubscriberOnNextListener;

import rx.Subscription;

/**
 * Created by dc on 2017/04/15
 */

public class IWeatherModelImpl extends BaseModel implements IWeatherModel{
    private final String TAG = "IWeatherModelImpl";

    private Context context = null;
    private RetrofitApiService retrofitApiService;
    public IWeatherModelImpl(Context context) {
        this.context = context;
        retrofitApiService = retrofitManager.getService();
    }

    @Override
    public void loadWeather(String city, String key, final IBaseRequestCallBack iBaseRequestCallBack) {
        Subscription subscription = new ProgressSubscriber<>(new SubscriberOnNextListener<WeatherInfoBean>() {
            @Override
            public void onNext(WeatherInfoBean tData) {
                String weatherInfoStr = "今天的天气：" + tData.getResult().getRealtime().getWeather().getTemperature();
                Log.e(TAG,  weatherInfoStr);
                iBaseRequestCallBack.requestSuccess(tData);
            }
        }, context);

        retrofitManager.laodWeatherInfo(subscription,city, key);
        addSubscrebe(subscription);
    }

    @Override
    public void onUnsubscribe() {
        //判断状态
        if(mCompositeSubscription != null && !mCompositeSubscription.isUnsubscribed()){
            Log.e(TAG, "注销rxjava");
            mCompositeSubscription.clear();  //注销
            mCompositeSubscription.unsubscribe();
        }
    }
}