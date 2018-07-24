package com.shubham.learningdagger.Main;

import com.shubham.learningdagger.DI.ActivityScoped;
import com.shubham.learningdagger.Interfaces.MainActivityMVP;
import com.shubham.learningdagger.Response.Articles;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@ActivityScoped
public class MainActivityPresenter implements MainActivityMVP.MAPresenter{
    private MainActivityMVP.MAView maView;
    private Subscription subscription=null;
    private MainActivityMVP.MAmodel mAmodel;

    @Inject
    public MainActivityPresenter(MainActivityMVP.MAmodel mAmodel) {
        this.mAmodel = mAmodel;
    }

    @Override
    public void loadData() {
        if(maView!=null){
            mAmodel.fetchNews(maView.getKey()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Articles>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                    if(maView!=null){
                        maView.setLoadingIndicator(false);
                        maView.showError(e.getMessage());
                    }

                }

                @Override
                public void onNext(Articles articles) {
                    if(maView!=null){
                        if(articles.getStatus().equals("ok")){
                            maView.ShowData(articles.getArticles());
                        }
                    }
                }
            });
        }
    }

    @Override
    public void unsubscribeStream() {
        if(subscription!=null){
            if(!subscription.isUnsubscribed())
                subscription.unsubscribe();
        }
    }

    @Override
    public void TakeView(MainActivityMVP.MAView view) {
        this.maView=view;
    }

    @Override
    public void DropView() {
        maView=null;
    }
}
