package com.example.guannan.mvp_library.Presenter;

import android.os.Bundle;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/21 16:18
 * @des 基类Presenter, 使用view泛型
 */

public class BasePresenter<V extends BaseViewInterface> implements BasePresenterInterface{

    private V mView;

    public BasePresenter() {
    }

    /**
     * 绑定view
     * @param view
     */
    public void onAttachView(V view){
        this.mView = view;
    }

    /**
     * 解除绑定View
     */
    public void onDetachView(){
        this.mView = null;
    }

    public V getView() {
        return mView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}
