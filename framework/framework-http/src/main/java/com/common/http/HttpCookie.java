package com.common.http;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * date :           2020/12/11 13:35
 * author :         鹏
 * description ：   保存 cookie
 * todo  cookie 本地持久化保存待完善
 */
public class HttpCookie implements CookieJar {

    private List<Cookie> mCookies = new ArrayList<>();
    //过期的Cookie
    private List<Cookie> invalidCookies = new ArrayList<>();
    //有效的Cookie
    private List<Cookie> validCookies = new ArrayList<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<okhttp3.Cookie> cookies) {
        mCookies.addAll(cookies);
    }

    @Override
    public List<okhttp3.Cookie> loadForRequest(HttpUrl url) {

        if (invalidCookies != null && invalidCookies.size() > 0) {
            invalidCookies.clear();
        } else {
            invalidCookies = new ArrayList<>();
        }
        if (validCookies != null && validCookies.size() > 0) {
            validCookies.clear();
        } else {
            validCookies = new ArrayList<>();
        }
        for (Cookie cookie : mCookies) {
            if (cookie.expiresAt() < System.currentTimeMillis()) {
                invalidCookies.add(cookie);
            } else if (cookie.matches(url)) {
                validCookies.add(cookie);
            }
            // 移除过期 cookie
            mCookies.remove(invalidCookies);
        }
        return validCookies;
    }
}
