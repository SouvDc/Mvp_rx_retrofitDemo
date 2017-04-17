package com.mvp_rx_retrofitdemo.weather.presenter;

/**
 * 描述：
 * 作者：dc on 2017/4/15 11:32
 * 邮箱：597210600@qq.com
 */
public interface IWeatherPresenter {

    /**
     * @descriptoin	获取网络数据
     * @author	dc
     * @param city 城市
     *             @param key key
     * @date 2017/2/17 19:01
     */
    void loadWeather(String city,String key);
}
