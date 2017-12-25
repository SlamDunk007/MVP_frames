package com.example.guannan.mvp_library.Proxy;

import com.example.guannan.mvp_library.Factory.MvpFactoryInterface;
import com.example.guannan.mvp_library.Presenter.FragmentPresenter;
import com.example.guannan.mvp_library.Presenter.FragmentPresenterInterface;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 19:11
 */

public class FragmentDelegate<V extends BaseViewInterface, P extends FragmentPresenter<V>> implements FragmentPresenterInterface<V> {

    private MvpFactoryInterface<V, P> mFactory;
    private P mPresenter;

    public FragmentDelegate(MvpFactoryInterface<V, P> fragmentFactory) {
        this.mFactory = fragmentFactory;
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    public P getPresenter() {
        if (mFactory != null) {
            if (mPresenter == null) {
                mPresenter = mFactory.createPresenter();
            }
            return mPresenter;
        }
        return null;
    }

    @Override
    public void onCreate() {
        getPresenter(); //创建Presenter
        if (mPresenter != null) {
            mPresenter.onCreateView();
        }
    }

    @Override
    public void onCreateView() {
        if (mPresenter != null) {
            mPresenter.onCreateView();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (mPresenter != null) {
            mPresenter.setUserVisibleHint(isVisibleToUser);
        }
    }

    @Override
    public void onHiddenChange(boolean hidden) {
        if (mPresenter != null) {
            mPresenter.onHiddenChange(hidden);
        }
    }

    @Override
    public void onStart() {
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @Override
    public void onResume(V view) {
        if (mPresenter != null) {
            mPresenter.onResume(view);
            mPresenter.onAttachView(view);
        }
    }

    @Override
    public void onPause() {
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.onDestroyView();
            mPresenter.onDetachView();
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }
}
