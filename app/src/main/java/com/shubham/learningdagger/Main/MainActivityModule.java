package com.shubham.learningdagger.Main;

import com.shubham.learningdagger.DI.ActivityScoped;
import com.shubham.learningdagger.DI.FragmentScoped;
import com.shubham.learningdagger.Interfaces.MainActivityMVP;
import com.shubham.learningdagger.Interfaces.RetrofitGeneratedAPI;
import com.shubham.learningdagger.data.DataModule;
import com.shubham.learningdagger.data.DataRepository;
import com.shubham.learningdagger.data.DataRepositoryImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class MainActivityModule {


    // Generating subcomponent for my fragment

    // binds method must have a parameter and return type of paramter must be assignable to return type of binds method.
    // you can only pass concrete implementation in it as parameters.


    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainActivityFragment mainActivityFragment();

    @ActivityScoped
    @Binds abstract MainActivityMVP.MAPresenter providesmaPresenter(MainActivityPresenter mainActivityPresenter);


    @ActivityScoped
    @Binds abstract MainActivityMVP.MAmodel providesmAmodel(MainActivityModel mainActivityModel);


    @ActivityScoped
    @Binds abstract DataRepository providesdataRepository(DataRepositoryImpl repository);

}
