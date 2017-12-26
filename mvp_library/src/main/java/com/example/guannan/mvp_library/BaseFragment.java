package com.example.guannan.mvp_library;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guannan.mvp_library.Factory.FragmentFactoryImpl;
import com.example.guannan.mvp_library.Presenter.FragmentPresenter;
import com.example.guannan.mvp_library.Proxy.FragmentDelegate;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 19:28
 */

public class BaseFragment<V extends BaseViewInterface, P extends FragmentPresenter<V>> extends Fragment {

    /**
     * 创建代理对象，将代理中的相关生命周期和Fragment的生命周期进行绑定
     */
    FragmentDelegate<V, P> mFragmentDelegate = (FragmentDelegate<V, P>) new FragmentDelegate<>(FragmentFactoryImpl.createFactory(getClass()));

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onCreate();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mFragmentDelegate != null) {
            mFragmentDelegate.setUserVisibleHint(isVisibleToUser);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onHiddenChange(hidden);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onResume((V) this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFragmentDelegate != null) {
            mFragmentDelegate.onDestroy();
        }
    }

    /**
     * 获取Presenter
     * @return
     */
    public P getPresenter(){
        if(mFragmentDelegate!=null){
            return mFragmentDelegate.getPresenter();
        }
        return null;
    }
}
