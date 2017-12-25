package com.example.guannan.mvp_library;

import android.app.Activity;
import android.os.Bundle;

import com.example.guannan.mvp_library.Factory.ActivityFactoryImpl;
import com.example.guannan.mvp_library.Presenter.ActivityPresenter;
import com.example.guannan.mvp_library.Proxy.ActivityDelegate;
import com.example.guannan.mvp_library.View.BaseViewInterface;

public class BaseActivity<V extends BaseViewInterface, P extends ActivityPresenter<V>> extends Activity {

    /**
     * 创建代理对象，将代理中的相关生命周期和Activity的生命周期进行绑定
     */
    ActivityDelegate<V, P> mDelegate = (ActivityDelegate<V, P>) new ActivityDelegate<>(ActivityFactoryImpl.createFactory(getClass()));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mDelegate != null) {
            mDelegate.onCreate();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mDelegate != null) {
            mDelegate.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDelegate != null) {   //在页面可见的时候，将Presenter和View进行绑定
            mDelegate.onResume((V) this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mDelegate != null) {
            mDelegate.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mDelegate != null) {
            mDelegate.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDelegate != null) {
            mDelegate.onDestroy();
        }
    }

    /**
     * 获取Presenter对象
     *
     * @return
     */
    public P getPresenter() {
        if (mDelegate != null) {
            P presenter = mDelegate.getPresenter();
            return presenter;
        }
        return null;
    }
}
