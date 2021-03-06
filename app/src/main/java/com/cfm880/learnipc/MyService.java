package com.cfm880.learnipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.cfm880.learnipc.datasource.RetrofitHelper;
import com.cfm880.learnipc.datasource.entity.NewsList;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyService extends Service {
    public MyService() {
    }


    private CopyOnWriteArrayList<ICallback> mListenerList = new CopyOnWriteArrayList<>();
    private AtomicBoolean mIsDestroy = new AtomicBoolean(false);


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private IPullingService.Stub mBinder = new IPullingService.Stub() {
        @Override
        public void getLastNews() throws RemoteException {
            RetrofitHelper.getUpdate().getNews().enqueue(new Callback<NewsList>() {
                @Override
                public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                    try {
                        mListenerList.get(0).getData(response.body());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<NewsList> call, Throwable t) {

                }
            });
        }

        @Override
        public void registerListener(ICallback listener) throws RemoteException {
            if (!mListenerList.contains(listener)){
                mListenerList.add(listener);
            } else {
                Log.d("MyService", "已存在");
            }

        }

        @Override
        public void unregisterListener(ICallback listener) throws RemoteException {
            if (mListenerList.contains(listener)){
                mListenerList.remove(listener);
            } else {
                Log.d("MyService", "不存在该listener");
            }
        }


    };

    @Override
    public void onCreate() {
        super.onCreate();
        Timer timer = new Timer("hh");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    mBinder.getLastNews();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5000);
    }

    @Override
    public void onDestroy() {

        mIsDestroy.set(true);
        System.out.println("onDestroy");
        super.onDestroy();
    }

}
