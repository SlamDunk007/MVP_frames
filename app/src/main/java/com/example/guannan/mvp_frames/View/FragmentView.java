package com.example.guannan.mvp_frames.View;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 19:40
 */

public interface FragmentView extends BaseViewInterface {

    void onSuccess(String content);

    void onFailure(String message);
}
