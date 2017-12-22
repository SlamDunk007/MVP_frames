package com.example.guannan.mvp_frames.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author guannan
 * @date 2017/12/13 14:21
 */

public interface GetRequestInterface {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello")
    Call<TransiContent> getContent();

}
