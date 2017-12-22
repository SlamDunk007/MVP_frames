package com.example.guannan.mvp_library.Proxy;

import android.os.Bundle;

import com.example.guannan.mvp_library.Factory.MvpFactoryInterface;
import com.example.guannan.mvp_library.Presenter.BasePresenter;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/21 17:05
 */

public class MvpProxy<V extends BaseViewInterface, P extends BasePresenter<V>> implements MvpProxyInterface{

    private MvpFactoryInterface<V,P> mProxyFactory;
    private P mPresenter;

    public MvpProxy(MvpFactoryInterface<V,P> mvpFactory){
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
        }
        return mPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getPresenter(); //创建Presenter实例
        if(mPresenter!=null){
            mPresenter.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onStart() {

        if(mPresenter!=null){
            mPresenter.onStart();
        }
    }

    public void onResume(V view) {
        if(mPresenter!=null){
            mPresenter.onResume();
            mPresenter.onAttachView(view);  //绑定presenter和View
        }
    }

    @Override
    public void onDetachView() {

        if(mPresenter!=null){
            mPresenter.onDetachView();
        }
    }

    @Override
    public void onPause() {

        if(mPresenter!=null){
            mPresenter.onPause();
        }
    }

    @Override
    public void onDestroy() {
        if(mPresenter!=null){
            mPresenter.onDestroy();
        }
    }
}
