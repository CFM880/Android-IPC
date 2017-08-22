package com.cfm880.learnipc.datasource.intercepter;

import com.cfm880.learnipc.CommonUtil;
import com.cfm880.learnipc.IPCApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ${DESCRIPTION}
 *
 * @author ChengFangming
 * @email chengfangming1993@gmail.com
 * @create 2017-08-22 下午2:32
 * Created by chengfangming on 2017/8/22.
 */

public class NoCacheIntercepter implements Interceptor{


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (CommonUtil.isNetworkAvailable(IPCApplication.getInstance())) {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .removeHeader("etag")
                    .removeHeader("last-modified")
                    .header("Cache-Control", "public, max-age=" + 0)
                    .build();
        }
        return response;
    }
}
