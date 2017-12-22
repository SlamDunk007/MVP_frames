package com.example.guannan.mvp_library.Proxy;

import android.os.Bundle;

/**
 * @author guannan
 * @date 2017/12/21 17:31
 */

public interface MvpProxyInterface {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onDetachView();

    void onPause();

    void onDestroy();

}
