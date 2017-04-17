package com.mvp_rx_retrofitdemo.weather.presenter;


import android.content.Context;
import android.util.Log;

import com.mvp_rx_retrofitdemo.base.BaseRxPresenter;
import com.mvp_rx_retrofitdemo.bean.WeatherInfoBean;
import com.mvp_rx_retrofitdemo.weather.model.IWeatherModelImpl;
import com.mvp_rx_retrofitdemo.weather.view.IWeatherView;

/**
* Created by dc on 2017/04/15
*/

public class IWeatherPresenterImpl extends BaseRxPresenter<IWeatherView,WeatherInfoBean> implements IWeatherPresenter{
    private final String TAG = "IWeatherPresenterImpl";

    private Context context = null;
    private IWeatherView iWeatherView = null;
    private IWeatherModelImpl iWeatherModel = null;

    public IWeatherPresenterImpl(Context context, IWeatherView iWeatherView) {
        super(iWeatherView);
        this.context = context;
        this.iWeatherView = iWeatherView;
        iWeatherModel = new IWeatherModelImpl(context);
    }

    @Override
    public void loadWeather(String city, String key)     {
        iWeatherModel.loadWeather(city, key, this);
    }

    @Override
    public void detachView() {
        Log.e(TAG," presenter 销毁 rx");
        iWeatherModel.onUnsubscribe();
    }

}