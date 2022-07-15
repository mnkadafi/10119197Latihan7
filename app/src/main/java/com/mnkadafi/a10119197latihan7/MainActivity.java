package com.mnkadafi.a10119197latihan7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mnkadafi.a10119197latihan7.Adapter.NewsAdapter;
import com.mnkadafi.a10119197latihan7.Api.APIService;
import com.mnkadafi.a10119197latihan7.Api.ApiEndPoint;
import com.mnkadafi.a10119197latihan7.Model.NewsModel;
import com.mnkadafi.a10119197latihan7.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private NewsAdapter viewAdapter;
    private List<NewsModel> mItems = new ArrayList<>();

    @BindView(R.id.recycler_news)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ButterKnife.bind(this);

        viewAdapter = new NewsAdapter(this, mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataNews();
    }

    private void loadDataNews() {

        //Declare Retrofit
        APIService api = ApiEndPoint.getClient().create(APIService.class);

        Call<ResponseModel> call = api.getNewsData();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    mItems = response.body().data;
                    System.out.println("STATUS data "+mItems);
                    viewAdapter = new NewsAdapter(MainActivity.this, mItems);
                    recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Oops, your connection is WONGKY! ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}