package com.mvp_rx_retrofitdemo.base;

/**
 * 描述：请求数据的回调接口
 * Presenter用于接受model获取（加载）数据后的回调
 * 作者：dc on 2017/2/16 11:22
 * 邮箱：597210600@qq.com
 */
public interface IBaseRequestCallBack<T> {

    /**
     * @descriptoin	请求成功
     * @author	dc
     * @param callBack 根据业务返回相应的数据
     * @date 2017/2/16 11:35
     */
    void requestSuccess(T callBack);
}
