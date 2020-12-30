package com.base.ui;

import android.content.Context;

/**
 * date :           2020/12/30 15:30
 * author :         鹏
 * description ：   TODO:类的作用
 */
public class OriginalContext {

    private static Context sContext;

    public static Context getContext() {
        if (sContext == null)
            throw new NullPointerException("请先在 Application 中调用 OriginalContext.setContext()进行初始化...");
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
