package com.example.guannan.mvp_frames.Presenter;

import com.example.guannan.mvp_frames.Model.RequestManager;
import com.example.guannan.mvp_frames.Model.TransiContent;
import com.example.guannan.mvp_frames.View.FragmentView;
import com.example.guannan.mvp_library.Presenter.FragmentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author guannan
 * @date 2017/12/25 19:44
 */

public class RequestFragmentPresenter extends FragmentPresenter<FragmentView> {

    public void getContent(){
        Call<TransiContent> content = RequestManager.getContent();
        content.enqueue(new Callback<TransiContent>() {
            @Override
            public void onResponse(Call<TransiContent> call, Response<TransiContent> response) {

                getView().onSuccess(response.body().getContent().getPh_am());
            }

            @Override
            public void onFailure(Call<TransiContent> call, Throwable t) {
                getView().onFailure(t.getMessage());
            }
        });
    }
}
