package com.cfm880.learnipc;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

/**
 * Created by chengfangming on 2017/6/7.
 */

public class IPCApplication extends Application {
    private static Application mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9306393489443765~7323539530");
    }

    public static Application getInstance() {
        return mInstance;
    }
}
