package com.mvp_rx_retrofitdemo.base;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * 描述： 基于Rx的Presenter的订阅者的生命周期
 * 作者：dc on 2017/4/15 11:39
 * 邮箱：597210600@qq.com
 */
public class BaseRxPresenter<V extends IBaseView , T> implements IBasePresenter ,IBaseRequestCallBack<T>{

    protected IBaseView iBaseView;

    public BaseRxPresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        this.iBaseView = null;
    }

    @Override
    public void requestSuccess(T callBack) {
        String weatherInfoStr = "今天的天气：" + iBaseView ;
        Log.e(TAG,  weatherInfoStr);
        iBaseView.loadDataSuccess(callBack);
    }
}
