package com.http.retrofit.base;

/**
 * date :           2020/12/30 09:50
 * author :         鹏
 * description ：   返回数据
 */
public class BaseResponse<T> {
    // 错误代码
    private int error_code;
    // 返回请求信息
    private String reason;
    // 返回的数据
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
