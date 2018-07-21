package com.shubham.learningdagger.DI;

import android.app.Application;

import com.shubham.learningdagger.data.DataModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        DataModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<MyApplication>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        ApplicationComponent.Builder application(Application application);
        ApplicationComponent build();
    }
}
