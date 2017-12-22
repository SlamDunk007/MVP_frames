package com.example.guannan.mvp_frames.Model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author guannan
 * @date 2017/12/13 14:02
 */

public class RequestManager {

    public static Call<TransiContent> getContent(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetRequestInterface requestInterface = retrofit.create(GetRequestInterface.class);

        Call<TransiContent> content = requestInterface.getContent();
        return content;
    }

}
