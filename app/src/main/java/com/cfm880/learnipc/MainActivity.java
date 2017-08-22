package com.cfm880.learnipc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.util.DebugUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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
    private IPullingService mService;
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

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = IPullingService.Stub.asInterface(service);
                try {
                    mService.getLastNews();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                try {
                    mService.registerListener(mCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                try {
                    mService.unregisterListener(mCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }, BIND_AUTO_CREATE);
    }
    ICallback.Stub mCallback = new ICallback.Stub() {
        @Override
        public void getData(NewsList newsList) throws RemoteException {
            Toast.makeText(MainActivity.this, newsList.getResult().get(0).getNews_title(), Toast.LENGTH_SHORT).show();
        }
    };

}
