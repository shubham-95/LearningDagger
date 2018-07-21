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
@Module(includes = {MainActivitySubModule.class})
public abstract class MainActivityModule {


    // Generating subcomponent for my fragment
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainActivityFragment mainActivityFragment();
}
