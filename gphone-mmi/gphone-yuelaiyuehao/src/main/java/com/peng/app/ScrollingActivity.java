package com.peng.app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.http.retrofit.base.BaseObserver;
import com.http.retrofit.base.DialogObserver;
import com.http.retrofit.base.RetrofitRequestManger;
import com.http.retrofit.bean.Bean;
import com.http.retrofit.bean.Weather;
import com.http.retrofit.utils.RxHelper;
import com.http.service.ApiService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ScrollingActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = findViewById(R.id.lv);
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_view_item, new String[]{"1"}));

        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                req();
            }
        });

    }

    private void req1() {
        RetrofitRequestManger.getInstance().getRetrofit().create(ApiService.class)
                .getWeatherInfo("深圳", "19f7c5051b12a7c73b69251f59ba534f")
                .compose(RxHelper.observableIO2Main(this))
                .subscribe(new DialogObserver<Weather.ResultDTO>(this) {

                    @Override
                    public void onSuccess(Weather.ResultDTO result) {
                        Toast.makeText(ScrollingActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable throwable, String errMsg) {
                        Toast.makeText(ScrollingActivity.this, "errMsg", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void req() {
        RetrofitRequestManger.getInstance().getRetrofit().create(ApiService.class)
                .getData1()
                .compose(RxHelper.observableIO2Main(this))
                .subscribe(new BaseObserver<Bean>() {
                    @Override
                    public void onSuccess(Bean result) {
                        Toast.makeText(ScrollingActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable throwable, String errMsg) {
                        Toast.makeText(ScrollingActivity.this, errMsg, Toast.LENGTH_SHORT).show();
                    }
                });

//        RetrofitRequestManger.getInstance()
//                .getRetrofit()
//                .create(ApiService.class)
//                .getData()
//                .compose(RxHelper.observableIO2Main(this))
//                .subscribe(new Observer<ZhBean>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull ZhBean zhBean) {
//                        Toast.makeText(ScrollingActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}