package com.example.guannan.mvp_frames.View;

import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/22 11:42
 */

public interface RequestView extends BaseViewInterface {

    void onSuccess(String content);

    void onFailure(String message);
}
