package com.shubham.learningdagger.Main;

import com.shubham.learningdagger.Interfaces.MainActivityMVP;
import com.shubham.learningdagger.Interfaces.RetrofitGeneratedAPI;
import com.shubham.learningdagger.data.DataModule;
import com.shubham.learningdagger.data.DataRepository;
import com.shubham.learningdagger.data.DataRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivitySubModule {
    @Provides
    MainActivityMVP.MAPresenter providesmainActivityPresenter(MainActivityMVP.MAmodel mAmodel){
        return new MainActivityPresenter(mAmodel);
    }

    @Provides
    MainActivityMVP.MAmodel providesMAmodel(DataRepository dataRepository){
        return new MainActivityModel(dataRepository);
    }
    @Provides
    DataRepository providesdataRepository(RetrofitGeneratedAPI retrofitGeneratedAPI){
        return new DataRepositoryImpl(retrofitGeneratedAPI);
    }
}
