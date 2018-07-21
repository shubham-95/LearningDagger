package com.shubham.learningdagger.data;

import android.content.Context;

import com.shubham.learningdagger.Interfaces.RetrofitGeneratedAPI;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private  static  final  int  CONNECT_TIMEOUT  =  40 ;
    private  static  final  int  WRITE_TIMEOUT  =  40 ;
    private  static  final  int  READ_TIMEOUT  =  40 ;


    @Provides
    @Singleton
    public RetrofitGeneratedAPI providesRetrofitGeneratedAPI(){
        OkHttpClient.Builder httpclient=new OkHttpClient.Builder();
        httpclient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpclient.readTimeout(READ_TIMEOUT,TimeUnit.SECONDS);
        httpclient.writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS);
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .client(httpclient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(RetrofitGeneratedAPI.class);
    }
}
