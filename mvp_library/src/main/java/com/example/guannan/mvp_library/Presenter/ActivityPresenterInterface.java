package com.example.guannan.mvp_library.Presenter;

import android.content.Intent;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 16:32
 * 创建Activity特有的一些方法
 */

public interface ActivityPresenterInterface<V extends BaseViewInterface> extends PresenterInterface<V>{

    void onNewIntent(Intent intent);
}
