package com.mvp_rx_retrofitdemo.base;


import android.util.Log;

import com.mvp_rx_retrofitdemo.helper.RetrofitManager;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static android.content.ContentValues.TAG;

/**
 * 描述：业务对象的基类
 * 作者：dc on 2017/2/16 14:02
 * 邮箱：597210600@qq.com
 */
public abstract class BaseModel {
    protected CompositeSubscription mCompositeSubscription;
    //retrofit请求数据的管理类
    public RetrofitManager retrofitManager;

    public BaseModel() {
        retrofitManager = RetrofitManager.builder();
    }

    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
        Log.e(TAG, "------------------" + mCompositeSubscription.isUnsubscribed());
    }

    public abstract void onUnsubscribe();
}
