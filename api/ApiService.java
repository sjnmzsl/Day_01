package com.example.one.api;

import com.example.one.bean.AchievementBean;
import com.example.one.bean.BannBean;
import com.example.one.bean.JournalismBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URl="http://cdwan.cn:7000/exam2003/";

    @GET("abannerlist.json")
    Observable<BannBean> getBannBean();

//    anewslist.json

    @GET("anewslist.json")
    Observable<JournalismBean> getJournalismBean();

    @GET("astudent.json")
    Observable<AchievementBean> getAcheiBean();
}
