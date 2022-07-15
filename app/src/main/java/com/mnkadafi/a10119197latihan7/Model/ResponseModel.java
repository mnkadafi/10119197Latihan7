package com.mnkadafi.a10119197latihan7.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {
    @SerializedName("category")
    public String category;
    @SerializedName("data")
    public List<NewsModel> data = new ArrayList<>();

    public List<NewsModel> getData() {
        return data;
    }
}
