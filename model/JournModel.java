package com.example.one.model;

import android.util.Log;

import com.example.one.api.ApiService;
import com.example.one.bean.AchievementBean;
import com.example.one.bean.BannBean;
import com.example.one.bean.JournalismBean;
import com.example.one.contract.HomeContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JournModel implements HomeContract.IHomeModel{

    @Override
    public void getData(HomeContract.IHomePresenter iHomePresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getJournalismBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JournalismBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull JournalismBean journalismBean) {
                        iHomePresenter.success(journalismBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        iHomePresenter.failure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
