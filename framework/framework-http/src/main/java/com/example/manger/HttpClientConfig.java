package com.example.manger;

/**
 * date :           2020/12/9 14:20
 * author :         鹏
 * description ：   TODO:类的作用
 */
public class HttpClientConfig {

    public static final long DEFAULT_TIME_OUT = 60;
    public static final long DEFAULT_READ_TIME_OUT = 60;
    public static final long DEFAULT_WRITE_TIME_OUT = 60;


        public static String BASE_URL = "http://japi.juhe.cn/joke/content/text.from";
//        public static String BASE_URL = "http://japi.juhe.cn/joke/content/text.from?key=ae240f7fba620fc370b803566654949e&page=1&pagesize=10";
//    public static String BASE_URL = "https://zhuanlan.zhihu.com/api/columns/zhihuadmin";
//            public static  String BASE_URL = "https://www.tianqiapi.com/free/day?appid=23035354&appsecret=8YvlPNrz&city=长沙";

    // 设置 debug 模式
    public static boolean isDebug = true;

}
