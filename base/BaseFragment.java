package com.example.one.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T> extends Fragment {
    protected T presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getViewId(), container, false);
        presenter = getPresenter();
        initView(view);
        initData();
        return view;
    }

    protected abstract T getPresenter();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getViewId();


}
