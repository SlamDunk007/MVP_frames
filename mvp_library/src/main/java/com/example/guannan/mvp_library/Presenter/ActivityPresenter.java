package com.example.guannan.mvp_library.Presenter;

import android.content.Intent;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 16:35
 * 给Presenter添加生命周期，把复杂的逻辑操作全部放在Presenter中进行处理，Activity中只做初始化和显示
 */

public class ActivityPresenter<V extends BaseViewInterface> implements ActivityPresenterInterface<V> {

    private V mView;

    public ActivityPresenter() {
    }

    /**
     * 绑定Presenter和View
     *
     * @param view
     */
    public void onAttachView(V view) {
        this.mView = view;
    }

    /**
     * 解绑Presenter和View
     */
    public void onDetachView() {
        this.mView = null;
    }

    public V getView() {
        if (mView != null) {
            return mView;
        }
        return null;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume(V view) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }
}
