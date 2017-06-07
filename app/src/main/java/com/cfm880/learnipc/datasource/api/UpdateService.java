package com.cfm880.learnipc.datasource.api;

import com.cfm880.learnipc.datasource.entity.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chengfangming on 2017/6/7.
 */

public interface UpdateService {
    @GET("/update.json")
    Call<NewsList> getNews();
}
