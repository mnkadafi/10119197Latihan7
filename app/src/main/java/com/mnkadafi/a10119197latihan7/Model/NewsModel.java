package com.mnkadafi.a10119197latihan7.Model;

import com.google.gson.annotations.SerializedName;

public class NewsModel {
    @SerializedName("author")
    public String author;
    @SerializedName("content")
    public String content;
    @SerializedName("date")
    public String date;
    @SerializedName("id")
    public String id;
    @SerializedName("imageUrl")
    public String imageUrl;
    @SerializedName("readMoreUrl")
    public String readMoreUrl;
    @SerializedName("time")
    public String time;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReadMoreUrl() {
        return readMoreUrl;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
