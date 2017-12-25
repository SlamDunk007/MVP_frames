package com.example.guannan.mvp_library.Presenter;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 17:34
 */

public class FragmentPresenter<V extends BaseViewInterface> implements FragmentPresenterInterface<V>{

    private V mView;

    public FragmentPresenter(){}

    /**
     * 绑定Presenter和View
     *
     * @param view
     */
    public void onAttachView(V view){
        this.mView = view;
    }
    /**
     * 解绑Presenter和View
     */
    public void onDetachView(){
        this.mView = null;
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
    public void onHiddenChange(boolean hidden) {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void onDestroyView() {

    }
}
