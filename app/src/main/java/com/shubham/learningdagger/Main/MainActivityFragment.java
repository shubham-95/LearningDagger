package com.shubham.learningdagger.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.shubham.learningdagger.DI.ActivityScoped;
import com.shubham.learningdagger.Interfaces.MainActivityMVP;
import com.shubham.learningdagger.R;
import com.shubham.learningdagger.Response.Article;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

@ActivityScoped
public class MainActivityFragment extends DaggerFragment implements MainActivityMVP.MAView{
    @Inject
    MainActivityMVP.MAPresenter maPresenter;

    @Inject
    public MainActivityFragment() {
        // Requires empty public constructor
    }
    private Activity mActivity;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;



    @Override
    public void onResume() {
        super.onResume();
        maPresenter.TakeView(this);
        progressBar.setVisibility(View.VISIBLE);
        maPresenter.loadData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        maPresenter.DropView();  //prevent leaking activity in
        // case presenter is orchestrating a long running task
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mainactivity_frag, container, false);
        recyclerView=(RecyclerView)root.findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)root.findViewById(R.id.progress_bar);
        return root;
    }





    @Override
    public void ShowData(List<Article> articleList) {
        progressBar.setVisibility(View.GONE);
        MainActivityRecyclerAdapter mainActivityRecyclerAdapter=new MainActivityRecyclerAdapter(mActivity,articleList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mainActivityRecyclerAdapter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public String getKey() {
        if(mActivity!=null)
            return mActivity.getResources().getString(R.string.key);
        return "NOT_VALID";
    }

    @Override
    public void showError(String msg) {
        if(progressBar.isShown())
            progressBar.setVisibility(View.GONE);
        Snackbar.make(getView(), msg, Snackbar.LENGTH_LONG).show();
    }
}
