package com.cfm880.learnipc.datasource;

import com.cfm880.learnipc.IPCApplication;
import com.cfm880.learnipc.datasource.api.UpdateService;
import com.cfm880.learnipc.datasource.auxiliary.APIConstant;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chengfangming on 2017/4/11.
 */

public class RetrofitHelper {
    private static OkHttpClient mOkHttpClient;

    static {
        initOkHttpClient();
    }



    public static UpdateService getUpdate(){
        return createApi(UpdateService.class);
    }
    private static <T> T createApi(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstant.HOST)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);

    }

    private static void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {
                    //设置Http缓存
                    Cache cache = new Cache(new File(IPCApplication.getInstance()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 10);

                    if (APIConstant.APP_DEBUG) {
                        mOkHttpClient = new OkHttpClient.Builder()
                                .cache(cache)
//                                .addInterceptor(new UrlInterceptor()) // 添加头和平台参数
                                .addInterceptor(interceptor)          // 缓存
//                                .addInterceptor(new AddResponseHeaderInterceptor(cache))
                                .addNetworkInterceptor(new StethoInterceptor())
                                .retryOnConnectionFailure(true)
                                .connectTimeout(30, TimeUnit.SECONDS)
                                .writeTimeout(20, TimeUnit.SECONDS)
                                .readTimeout(20, TimeUnit.SECONDS)
                                .build();
                    } else {
                        mOkHttpClient = new OkHttpClient.Builder()
                                .cache(cache)
//                                .addInterceptor(new UrlInterceptor()) // 添加头和平台参数
//                                .addInterceptor(new AddResponseHeaderInterceptor(cache))
                                .retryOnConnectionFailure(true)
                                .connectTimeout(30, TimeUnit.SECONDS)
                                .writeTimeout(20, TimeUnit.SECONDS)
                                .readTimeout(20, TimeUnit.SECONDS)
                                .build();
                    }

                }
            }
        }
    }
}
