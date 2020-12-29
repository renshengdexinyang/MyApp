package com.common.interface1;

import java.util.LinkedHashMap;

/**
 * date :           2020/12/11 09:37
 * author :         鹏
 * description ：   此接口提供一个通用请求方法
 */
public interface IRequestManger {
    /**
     * @param url      不带参数的请求地址
     * @param callback 回调方法
     */
    void get(String url, IRequestCallback callback);

    /**
     * @param url      请求地址
     * @param params   参数
     * @param callback 回调方法
     */
    void get(String url, LinkedHashMap<String, String> params, IRequestCallback callback);

    void post(String url, String requestBodyJson, IRequestCallback callback);

    /**
     * @param url      请求地址
     * @param params   参数
     * @param callback 回调方法
     */
    void post(String url, LinkedHashMap<String, String> params, IRequestCallback callback);

    void put(String url, String requestBodyJson, IRequestCallback callback);

    void delete(String url, String requestBodyJson, IRequestCallback callback);

}
