package com.shubham.learningdagger.data;

import com.shubham.learningdagger.Response.Articles;

import rx.Observable;

public interface DataRepository {
    Observable<Articles> getAllArticlesRepo(String key);
}
