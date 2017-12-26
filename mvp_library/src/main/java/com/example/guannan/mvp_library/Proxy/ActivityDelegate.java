package com.example.guannan.mvp_library.Proxy;

import android.content.Intent;

import com.example.guannan.mvp_library.Factory.MvpFactoryInterface;
import com.example.guannan.mvp_library.Presenter.ActivityPresenter;
import com.example.guannan.mvp_library.Presenter.ActivityPresenterInterface;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/21 17:05
 * 将Presenter中的生命周期，Presenter和View的关系代理到这里进行处理
 */

public class ActivityDelegate<V extends BaseViewInterface, P extends ActivityPresenter<V>> implements ActivityPresenterInterface<V>{

    private MvpFactoryInterface<V,P> mProxyFactory;
    private P mPresenter;

    public ActivityDelegate(MvpFactoryInterface<V,P> mvpFactory){
        this.mProxyFactory = mvpFactory;
    }

    /**
     * 在代理中获取Presenter
     * @return
     */
    public P getPresenter(){
        if(mProxyFactory!=null){
            if(mPresenter==null){
                mPresenter = mProxyFactory.createPresenter();
            }
            return mPresenter;
        }
        return null;
    }

    @Override
    public void onCreate() {
        getPresenter(); //创建Presenter的对象
        if(mPresenter!=null){
            mPresenter.onCreate();
        }
    }

    @Override
    public void onStart() {
        if(mPresenter!=null){
            mPresenter.onStart();
        }
    }

    @Override
    public void onResume(V view) {
        if(mPresenter!=null){
            mPresenter.onResume(view);
            mPresenter.onAttachView(view);  //将View和Presenter进行绑定
        }
    }


    @Override
    public void onPause() {
        if(mPresenter!=null){
            mPresenter.onPause();
        }
    }

    @Override
    public void onStop() {
        if(mPresenter!=null){
            mPresenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if(mPresenter!=null){
            mPresenter.onDestroy();
            mPresenter.onDetachView();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if(mPresenter!=null){
            mPresenter.onNewIntent(intent);
        }
    }
}
