package com.http.retrofit.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import io.reactivex.disposables.Disposable;

/**
 * date :           2020/12/30 13:58
 * author :         鹏
 * description ：   添加 "正在加载" 弹窗
 */
public abstract class DialogObserver<T> extends BaseObserver<T> {
    private Context mContext;
    private boolean isShowDialog;
    private Disposable mDisposable;
    private ProgressDialog mDialog;


    public DialogObserver(Context context) {
        this(context, true);
    }

    private DialogObserver(Context context, boolean isShowDialog) {
        this.isShowDialog = isShowDialog;
        this.mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
//        super.onSubscribe(d);
        this.mDisposable = d;
        if (!isConnected(mContext)) {
            Toast.makeText(mContext, "未连接网络", Toast.LENGTH_SHORT).show();
            if (d.isDisposed()) {
                d.dispose();
            }
        } else {
            if (mDialog == null && isShowDialog) {
                mDialog = new ProgressDialog(mContext);
                mDialog.setMessage("正在加载中...");
                mDialog.show();
            }
        }
    }

    @Override
    public void onComplete() {
        if (mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        hidDialog();
        super.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        if (mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        hidDialog();
        super.onError(e);
    }

    public void hidDialog() {
        if (mDialog != null && isShowDialog) {
            mDialog.dismiss();
        }
        mDialog = null;
    }

    /**
     * @param context
     * @return 是否有网路连接
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        return info.isAvailable();
    }
}
