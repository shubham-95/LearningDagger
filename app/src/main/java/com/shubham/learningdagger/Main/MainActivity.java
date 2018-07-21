package com.shubham.learningdagger.Main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.shubham.learningdagger.R;
import com.shubham.learningdagger.Util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Lazy<MainActivityFragment> mainActivityFragmentLazy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainActivityFragment mainActivityFragment=(MainActivityFragment)getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(mainActivityFragment==null){
            mainActivityFragment=mainActivityFragmentLazy.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), mainActivityFragment, R.id.contentFrame);
        }
    }
}
