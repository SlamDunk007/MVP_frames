package com.example.guannan.mvp_library.Presenter;

import android.os.Bundle;

/**
 * @author guannan
 * @date 2017/12/21 17:40
 * @des 给Presenter添加生命周期,便于控制,后期可扩展相关方法
 */

public interface BasePresenterInterface {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onDestroy();
}
