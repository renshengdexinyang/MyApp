package com.http.https;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * date :           2020/12/31 15:45
 * author :         鹏
 * description ：   TODO:类的作用
 */
public class TrustAllHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}
