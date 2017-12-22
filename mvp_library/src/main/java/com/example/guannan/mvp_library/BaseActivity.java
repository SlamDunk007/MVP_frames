package com.example.guannan.mvp_library;

import android.app.Activity;
import android.os.Bundle;

import com.example.guannan.mvp_library.Factory.MvpFactoryImpl;
import com.example.guannan.mvp_library.Presenter.BasePresenter;
import com.example.guannan.mvp_library.Proxy.MvpProxy;
import com.example.guannan.mvp_library.View.BaseViewInterface;

public class BaseActivity<V extends BaseViewInterface, P extends BasePresenter<V>> extends Activity {

    //创建代理对象，将代理中的相关生命周期和Activity的生命周期进行绑定
    MvpProxy<V, P> mProxy = (MvpProxy<V, P>) new MvpProxy<>(MvpFactoryImpl.createFactory(getClass()));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mProxy != null) {
            mProxy.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mProxy != null) {
            mProxy.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mProxy != null) {   //在页面可见的时候，将Presenter和View进行绑定
            mProxy.onResume((V) this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mProxy != null) {
            mProxy.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mProxy != null) {
            mProxy.onDestroy();
            mProxy.onDetachView();  //页面的销毁的时候，将Presenter和View解绑定。这样写可以避免OOM
        }
    }

    /**
     * 获取Presenter对象
     * @return
     */
    public P getPresenter(){
        if(mProxy!=null){
            P presenter = mProxy.getPresenter();
            return presenter;
        }
        return null;
    }
}
