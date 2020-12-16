package com.example.one.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.one.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ImageView ima;
    private TextView tv_time;
    private Disposable subscribe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ima = findViewById(R.id.ima_Main);
        tv_time = findViewById(R.id.tv_time);
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        long time = 3 - aLong;
                        tv_time.setText(time + "秒后跳转");
                        if (time == 0) {
                            jumpActivity();
                        }
                    }
                });
    }

    private void jumpActivity() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        subscribe.dispose();
    }
}