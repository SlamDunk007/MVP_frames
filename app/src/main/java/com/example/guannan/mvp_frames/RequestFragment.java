package com.example.guannan.mvp_frames;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.guannan.mvp_frames.Presenter.RequestFragmentPresenter;
import com.example.guannan.mvp_frames.View.FragmentView;
import com.example.guannan.mvp_library.BaseFragment;
import com.example.guannan.mvp_library.Inject.ViewConfig;

/**
 * @author guannan
 * @date 2017/12/25 19:40
 */
@ViewConfig(RequestFragmentPresenter.class)
public class RequestFragment extends BaseFragment<FragmentView,RequestFragmentPresenter> implements FragmentView{

    private TextView mTvShowContent;

    public static RequestFragment getFragment(){
        return new RequestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Button btnRequest = (Button) view.findViewById(R.id.btn_reqeust_data);
        mTvShowContent = (TextView) view.findViewById(R.id.tv_show_content);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().getContent();
            }
        });
    }

    @Override
    public void onSuccess(String content) {
        if(!TextUtils.isEmpty(content)){
            mTvShowContent.setText(content);
        }
    }

    @Override
    public void onFailure(String message) {
        if(!TextUtils.isEmpty(message)){
            mTvShowContent.setText(message);
        }
    }
}
