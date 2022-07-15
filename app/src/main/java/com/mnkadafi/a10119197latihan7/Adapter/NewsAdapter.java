package com.mnkadafi.a10119197latihan7.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mnkadafi.a10119197latihan7.MainActivity;
import com.mnkadafi.a10119197latihan7.Model.NewsModel;
import com.mnkadafi.a10119197latihan7.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder> {
    List<NewsModel> mList ;
    Context ctx;
    Activity activity;

    public NewsAdapter(Activity activity, Context ctx, List<NewsModel> mList) {
        this.activity = activity;
        this.mList = mList;
        this.ctx = ctx;
    }

    public NewsAdapter(MainActivity activity, List<NewsModel> mList) {
        this.activity = activity;
        this.mList = mList;
    }

    @NonNull
    @Override
    public NewsAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.MyHolder holder, int position) {
        NewsModel newsModel = mList.get(position);
        Glide
                .with(activity)
                .load(newsModel.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.progress_animation)
                .into(holder.imageView);
        holder.title.setText(newsModel.getTitle());
        holder.description.setText(newsModel.getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView imageView;
        NewsModel newsListModelData;
        public MyHolder(View v)
        {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.ivNews);
            title = (TextView) v.findViewById(R.id.tvTitle);
            description = (TextView) v.findViewById(R.id.tvDescription);
        }

    }
}
