package com.example.guannan.mvp_library.Factory;

import com.example.guannan.mvp_library.Presenter.PresenterInterface;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/21 16:34
 * @des 定义创建presenter的工厂的接口
 */

public interface MvpFactoryInterface<V extends BaseViewInterface, P extends PresenterInterface<V>> {

    P createPresenter();
}
