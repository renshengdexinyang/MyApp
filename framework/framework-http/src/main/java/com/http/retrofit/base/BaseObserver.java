package com.http.retrofit.base;


import com.http.retrofit.utils.RxException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * date :           2020/12/30 09:50
 * author :         鹏
 * description ：   对 Observer 进行二次封装
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponse<T> value) {
        if (value.getError_code() == 0) {
            onSuccess(value.getResult());
        } else {
            onFailure(null, value.getReason());
        }

    }

    @Override
    public void onError(Throwable e) {
        onFailure(e, RxException.exceptionHandler(e));
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T result);

    public abstract void onFailure(Throwable throwable, String errMsg);
}
