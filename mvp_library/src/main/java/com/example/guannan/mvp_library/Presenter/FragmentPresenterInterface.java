package com.example.guannan.mvp_library.Presenter;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 17:17
 */

public interface FragmentPresenterInterface<V extends BaseViewInterface> extends PresenterInterface<V>{

    void onHiddenChange(boolean hidden);

    void setUserVisibleHint(boolean isVisibleToUser);

    void onCreateView();

    void onDestroyView();
}
