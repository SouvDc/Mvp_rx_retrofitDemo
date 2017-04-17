package com.mvp_rx_retrofitdemo.weather.model;

import com.mvp_rx_retrofitdemo.base.IBaseRequestCallBack;

/**
* Created by dc on 2017/04/15
*/

public interface IWeatherModel<T>{

    /**
     * @descriptoin	获取网络数据
     * @author	dc
     * @param city 城市
     *             @param key key
     * @date 2017/2/17 19:01
     */
    void loadWeather(String city, String key, IBaseRequestCallBack<T> iBaseRequestCallBack);

}