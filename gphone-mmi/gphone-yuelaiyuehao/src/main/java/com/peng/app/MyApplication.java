package com.peng.app;

import android.app.Application;

import com.utils.AppInit;

/**
 * date :           2020/12/11 16:55
 * author :         鹏
 * description ：   TODO:类的作用
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppInit.init(this);
    }
}
