package com.example.one.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T> extends AppCompatActivity {
    protected T persenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        persenter=getPersenter();
        initView();
        initData();
    }

    protected abstract T getPersenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getViewId();
}
