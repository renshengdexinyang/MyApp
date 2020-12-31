package com.utils;

import android.content.Context;

/**
 * date :           2020/12/31 11:13
 * author :         鹏
 * description ：   TODO:类的作用
 */
public class AppInit {
    public static void init(Context context) {
        Res.setContext(context);
        OriginalContext.setContext(context);
    }
}
