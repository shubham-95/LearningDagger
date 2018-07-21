package com.shubham.learningdagger.Interfaces;

import com.shubham.learningdagger.Response.Article;
import com.shubham.learningdagger.Response.Articles;

import java.util.List;

import rx.Observable;

public interface MainActivityMVP {
    interface MAView extends BaseView<MAPresenter>{

        void ShowData(List<Article> articleList);
        void setLoadingIndicator(boolean active);
        String getKey();
        void showError(String msg);

    }
    interface MAPresenter extends BasePresenter<MAView>{
        void loadData();
        void unsubscribeStream();
    }
    interface MAmodel{
        Observable<Articles> fetchNews(String key);
    }
}
