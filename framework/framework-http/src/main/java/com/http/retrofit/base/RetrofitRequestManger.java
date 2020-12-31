package com.http.retrofit.base;

import com.http.Interceptor.HttpHeaderInterceptor;
import com.http.Interceptor.LoggerInterceptor;
import com.http.config.HttpClientConfig;
import com.http.https.HttpsFactroy;
import com.http.https.TrustAllHostnameVerifier;
import com.http.persistentcookiejar.PersistentCookieJar;
import com.http.persistentcookiejar.cache.SetCookieCache;
import com.http.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.utils.OriginalContext;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
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
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("application/json;charset=utf-8");

    private static class SingletonHolder {
        public static final RetrofitRequestManger INSTANCE = new RetrofitRequestManger();
    }

    public static RetrofitRequestManger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public RetrofitRequestManger() {
        HttpHeaderInterceptor mHeaderInterceptor = new HttpHeaderInterceptor();
        mHeaderInterceptor.addHeaderParams("Accept-Encoding", "identity");
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
                .sslSocketFactory(HttpsFactroy.createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
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
