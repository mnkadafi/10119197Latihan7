package com.mnkadafi.a10119197latihan7.Api;

import com.mnkadafi.a10119197latihan7.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("news?category=science")
    Call<ResponseModel> getNewsData();
}
