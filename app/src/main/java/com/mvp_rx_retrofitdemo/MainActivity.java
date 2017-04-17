package com.mvp_rx_retrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.mvp_rx_retrofitdemo.base.BaseActivity;
import com.mvp_rx_retrofitdemo.bean.WeatherInfoBean;
import com.mvp_rx_retrofitdemo.weather.presenter.IWeatherPresenterImpl;
import com.mvp_rx_retrofitdemo.weather.view.IWeatherView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IWeatherView{
    private final String TAG = "MainActivity";

    @Bind(R.id.button)
    Button button;

    private IWeatherPresenterImpl iWeatherPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        iWeatherPresenter = new IWeatherPresenterImpl(this,MainActivity.this);
    }

    @OnClick(R.id.button)
    public void onClickBtn(){
        iWeatherPresenter.loadWeather("c5bb749112664353af44bc99ed263857", "长沙");
    }

    @Override
    public void loadDataSuccess(WeatherInfoBean tData) {
        String weatherInfoStr = "今天的天气：" + tData.getResult().getRealtime().getWeather().getTemperature();
        Log.e(TAG,  weatherInfoStr);
        Toast.makeText(MainActivity.this, weatherInfoStr ,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        iWeatherPresenter.detachView();
        finish();
    }

}
