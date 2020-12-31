package com.http.Interceptor;

import com.google.gson.Gson;
import com.http.logger.Logger;
import com.utils.AppUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * date :           2020/12/9 14:21
 * author :         鹏
 * description ：   日志拦截器
 */
public class LoggerInterceptor implements Interceptor {

    public static final String TAG = "LoggerInterceptor";
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("application/json;charset=utf-8");

    public LoggerInterceptor() {

    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response response = chain.proceed(request);
        String responseContent = response.body().string();
        MediaType mediaType = response.body().contentType();
        if (AppUtils.getAppDebugMode()) {
            RequestBody body = request.body();
            Logger.d("method: " + request.method() + "      url: " + request.url());
            Logger.d("headers: " + request.headers());
            if (body != null) {
                Logger.d("request" + body.toString());
            }
            Logger.json(responseContent);
        }
        return response.newBuilder()
                .body(ResponseBody.create(mediaType, responseContent))
                .build();
    }
}
