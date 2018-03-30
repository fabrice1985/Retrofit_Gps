package com.example.bnfg.retrofit_gps.model.remote;

/**
 * Created by BNFG on 22/03/2018.
 */

import com.example.bnfg.retrofit_gps.model.post.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("latitude") double latitude,
                        @Field("longitude") double longitude);
}