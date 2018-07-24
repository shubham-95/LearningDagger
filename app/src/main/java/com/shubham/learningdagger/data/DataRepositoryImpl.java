package com.shubham.learningdagger.data;

import com.shubham.learningdagger.Interfaces.RetrofitGeneratedAPI;
import com.shubham.learningdagger.Response.Articles;

import javax.inject.Inject;

import rx.Observable;

public class DataRepositoryImpl implements DataRepository{

    private RetrofitGeneratedAPI retrofitGeneratedAPI;

    @Inject
    public DataRepositoryImpl(RetrofitGeneratedAPI retrofitGeneratedAPI) {
        this.retrofitGeneratedAPI = retrofitGeneratedAPI;
    }

    @Override
    public Observable<Articles> getAllArticlesRepo(String key) {
        return retrofitGeneratedAPI.getArticles(key);
    }
}
