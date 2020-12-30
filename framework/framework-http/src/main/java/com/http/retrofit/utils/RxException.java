package com.http.retrofit.utils;

import android.net.ParseException;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * date :           2020/12/30 09:51
 * author :         鹏
 * description ：   自定义错误提示消息
 */
public class RxException {

    public static String exceptionHandler(Throwable e) {
        String errMsg = "未知错误";
        if (e instanceof UnknownHostException) {
            errMsg = "网络不可用";
        } else if (e instanceof SocketTimeoutException) {
            errMsg = "连接超时";
        } else if (e instanceof HttpException) {
            errMsg = convertStatusCode((HttpException) e);
        } else if (e instanceof ParseException || e instanceof JSONException) {
            errMsg = "数据解析错误";
        }
            return errMsg;
    }

    private static String convertStatusCode(HttpException httpException) {
        String msg = "";
        if (httpException.code() >= 500 && httpException.code() < 600) {
            msg = "服务器处理请求出错";
        } else if (httpException.code() >= 400 && httpException.code() < 500) {
            msg = "服务器无法处理请求";
        } else if (httpException.code() >= 300 && httpException.code() < 400) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }
}
