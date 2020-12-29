package com.example.interface1;

/**
 * date :           2020/12/11 09:38
 * author :         鹏
 * description ：   请求结果回调
 */
public interface IRequestCallback {
    void onSuccess(String response);

    void onFailure(Throwable throwable);
}
