package com.shubham.learningdagger.DI;

import android.app.Application;
import android.content.Context;

import com.shubham.learningdagger.Interfaces.RetrofitGeneratedAPI;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context providesContext(Application application);
}
