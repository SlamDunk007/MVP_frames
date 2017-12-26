package com.example.guannan.mvp_frames;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guannan.mvp_frames.Presenter.RequestPresenter;
import com.example.guannan.mvp_frames.View.RequestView;
import com.example.guannan.mvp_library.BaseActivity;
import com.example.guannan.mvp_library.Inject.ViewConfig;

/**
 * @author guannan
 * @date 2017/12/21 20:37
 */
@ViewConfig(RequestPresenter.class)
public class MainActivity extends BaseActivity<RequestView,RequestPresenter> implements RequestView{

    private TextView mTvContent;
    private Button mBtnRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnRequest = (Button) findViewById(R.id.btn_reqeust_data);
        mTvContent = (TextView) findViewById(R.id.tv_show_content);
        Button btnJump = (Button) findViewById(R.id.btn_jump);
        mBtnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().getContent();
            }
        });
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fl_container,RequestFragment.getFragment(),"RequestFragment");
                transaction.commit();
            }
        });
    }

    @Override
    public void onSuccess(String content) {
       mTvContent.setText(content);
    }

    @Override
    public void onFailure(String message) {
        mTvContent.setText(message);
    }
}
