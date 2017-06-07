package com.cfm880.learnipc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cfm880.learnipc.adapter.NewsRVAdapter;
import com.cfm880.learnipc.datasource.RetrofitHelper;
import com.cfm880.learnipc.datasource.entity.NewsList;
import com.squareup.haha.perflib.Main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private NewsRVAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_news);
        RetrofitHelper.getUpdate().getNews().enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                mAdapter = new NewsRVAdapter(response.body().getResult());
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

            }
        });
    }
}
