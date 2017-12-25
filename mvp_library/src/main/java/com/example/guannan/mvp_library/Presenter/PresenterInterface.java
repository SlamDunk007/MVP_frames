package com.example.guannan.mvp_library.Presenter;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 16:29
 * 定义Activity里面一些常用的生命周期
 */

public interface PresenterInterface<V extends BaseViewInterface> {

    void onCreate();

    void onStart();

    void onResume(V view);

    void onPause();

    void onStop();

    void onDestroy();
}
