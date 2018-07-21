package com.shubham.learningdagger.DI;

import com.shubham.learningdagger.Main.MainActivity;
import com.shubham.learningdagger.Main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}
