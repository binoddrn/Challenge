package com.learn.binod.technoriochallenge.networking;

import com.learn.binod.technoriochallenge.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by binod on 10/5/2017.
 */

public interface ApiInterface {
    @GET("posts/")
    Call<PostResponse> getPostList();

    @GET("post/{id}")
    Call<PostResponse>getPostDetail(@Path("id") String id);
}
