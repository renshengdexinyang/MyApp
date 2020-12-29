package com.example.manger;

import com.example.interface1.IRequestManger;

/**
 * date :           2020/12/11 09:58
 * author :         鹏
 * description ：   通过统一工厂构建，替换网络请求框架只需要在此做更改即可
 */
public class RequestFactory {

    public static IRequestManger getRequestManger() {
        return OkHttpRequestManger.getInstance();
    }
}
