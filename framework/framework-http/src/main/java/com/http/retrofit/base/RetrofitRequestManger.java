package com.http.retrofit.base;

import com.base.ui.OriginalContext;
import com.http.Interceptor.HttpHeaderInterceptor;
import com.http.Interceptor.LoggerInterceptor;
import com.http.config.HttpClientConfig;
import com.http.persistentcookiejar.PersistentCookieJar;
import com.http.persistentcookiejar.cache.SetCookieCache;
import com.http.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.BridgeInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date :           2020/12/30 10:18
 * author :         鹏
 * description ：   初始化
 */
public class RetrofitRequestManger {
    private Retrofit mRetrofit;

    public static class SingletonHolder {
        public static final RetrofitRequestManger INSTANCE = new RetrofitRequestManger();
    }

    public RetrofitRequestManger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public RetrofitRequestManger() {
        HttpHeaderInterceptor mHeaderInterceptor = new HttpHeaderInterceptor();
        mHeaderInterceptor.addHeaderParams("userId", "123")
                .addHeaderParams("token", "aabbcc112233");
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpClientConfig.DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(HttpClientConfig.DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(HttpClientConfig.DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new BridgeInterceptor(
                        new PersistentCookieJar(
                                new SetCookieCache(),
                                new SharedPrefsCookiePersistor(OriginalContext.getContext()))))
                .addInterceptor(mHeaderInterceptor)
                .addInterceptor(new LoggerInterceptor())
                .retryOnConnectionFailure(true)
                .build();
        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(HttpClientConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
