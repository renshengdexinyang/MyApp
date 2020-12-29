package com.example.manger;

import com.example.Interceptor.HttpHeaderInterceptor;
import com.example.Interceptor.LoggerInterceptor;
import com.example.http.HttpCookie;
import com.example.interface1.IRequestCallback;
import com.example.interface1.IRequestManger;

import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.BridgeInterceptor;

/**
 * date :           2020/12/11 09:30
 * author :         鹏
 * description ：   TODO:类的作用
 */
public class OkHttpRequestManger implements IRequestManger {

    public static final MediaType TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient mOkHttpClient;

    /**
     * 保持全局只有一个实例
     */
    public static class SingletonHolder {
        public static final OkHttpRequestManger INSTANCE = new OkHttpRequestManger();
    }

    public static IRequestManger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public OkHttpRequestManger() {
        HttpHeaderInterceptor mHeaderInterceptor = new HttpHeaderInterceptor();
        mHeaderInterceptor.addHeaderParams("userId", "123")
                .addHeaderParams("token", "aabbcc112233");
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpClientConfig.DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(HttpClientConfig.DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(HttpClientConfig.DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new BridgeInterceptor(new HttpCookie()))
                .retryOnConnectionFailure(true)
//                .addNetworkInterceptor()
                .addInterceptor(mHeaderInterceptor)
                .addInterceptor(new LoggerInterceptor())
                .build();
    }

    @Override
    public void get(String url, IRequestCallback callback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        addCallBack(request, callback);
    }

    @Override
    public void get(String url, LinkedHashMap<String, String> params, IRequestCallback callback) {
        Iterator<String> key = params.keySet().iterator();
        Iterator<String> vaule = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                try {
                    stringBuffer.append(key.next() + "=" + URLEncoder.encode(vaule.next(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (i != params.size() - 1) {
                    stringBuffer.append("&");
                }
            }
        }
        Request request = new Request.Builder()
                .url(url + stringBuffer.toString())
                .get()
                .build();
        addCallBack(request, callback);
    }

    @Override
    public void post(String url, String requestBodyJson, IRequestCallback callback) {
        RequestBody requestBody = RequestBody.create(TYPE_JSON, requestBodyJson);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        addCallBack(request, callback);
    }

    @Override
    public void post(String url, LinkedHashMap<String, String> params, IRequestCallback callback) {
        Iterator<String> key = params.keySet().iterator();
        Iterator<String> vaule = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                try {
                    stringBuffer.append(key.next() + "=" + URLEncoder.encode(vaule.next(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (i != params.size() - 1) {
                    stringBuffer.append("&");
                }
            }
        }

        RequestBody requestBody = RequestBody.create(TYPE_JSON, new JSONObject(params).toString());
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        addCallBack(request, callback);
    }

    @Override
    public void put(String url, String requestBodyJson, IRequestCallback callback) {
        RequestBody requestBody = RequestBody.create(TYPE_JSON, requestBodyJson);
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();
        addCallBack(request, callback);
    }

    @Override
    public void delete(String url, String requestBodyJson, IRequestCallback callback) {
        RequestBody requestBody = RequestBody.create(TYPE_JSON, requestBodyJson);
        Request request = new Request.Builder()
                .url(url)
                .delete(requestBody)
                .build();
        addCallBack(request, callback);
    }

    private void addCallBack(Request request, IRequestCallback callback) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().string());
                    }
                } else {
                    callback.onFailure(new Exception(response.message() + " " + response.code()
                            + " url: " + call.request().url().toString()));
                }
            }
        });
    }
}
