package com.shubham.learningdagger.Interfaces;

import com.shubham.learningdagger.Response.Articles;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitGeneratedAPI {

    @GET("v2/top-headlines?country=in")
    Observable<Articles> getArticles(@Query("apiKey") String key);
}
