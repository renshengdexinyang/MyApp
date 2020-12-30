package com.http.Interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date :           2020/12/10 14:39
 * author :         鹏
 * description ：   向请求头添加参数
 */
public class HttpHeaderInterceptor implements Interceptor {
    private Map<String, String> mHeaderParamsMap = new HashMap<>();

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.method(request.method(), request.body())
                .removeHeader("Accept-Encoding");

        if (mHeaderParamsMap != null && mHeaderParamsMap.size() > 0) {
            for (Map.Entry<String, String> params : mHeaderParamsMap.entrySet()) {
                requestBuilder.header(params.getKey(), params.getValue());
            }
        }
        return chain.proceed(requestBuilder.build());
    }

    public <T> HttpHeaderInterceptor addHeaderParams(String key, T vaule) {
        mHeaderParamsMap.put(key, String.valueOf(vaule));
        return this;
    }

    public <T> HttpHeaderInterceptor delHeaderParams(String key) {
        mHeaderParamsMap.remove(key);
        return this;
    }
}
