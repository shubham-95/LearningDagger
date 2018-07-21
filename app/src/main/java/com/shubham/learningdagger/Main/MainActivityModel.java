package com.shubham.learningdagger.Main;

import com.shubham.learningdagger.Interfaces.MainActivityMVP;
import com.shubham.learningdagger.Response.Articles;
import com.shubham.learningdagger.data.DataRepository;

import rx.Observable;

public class MainActivityModel implements MainActivityMVP.MAmodel{
    private DataRepository dataRepository;

    public MainActivityModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Observable<Articles> fetchNews(String key) {
        return dataRepository.getAllArticlesRepo(key);
    }
}
