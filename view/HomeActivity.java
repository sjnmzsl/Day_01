package com.example.one.view;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.one.R;
import com.example.one.adapter.FragmentAdapter;
import com.example.one.base.BaseActivity;
import com.example.one.bean.BannBean;
import com.example.one.contract.HomeContract;
import com.example.one.fragment.AchievementFragment;
import com.example.one.fragment.JournalismFragment;
import com.example.one.presenter.HomePersenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity<HomePersenter> implements HomeContract.IHomeActivity<BannBean> {

    private Banner banner_Home;
    private ViewPager pager;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private FragmentAdapter adapter;

    @Override
    public HomePersenter getPersenter() {
        return new HomePersenter(this);
    }

    @Override
    protected void initData() {
        persenter.getData();
    }

    @Override
    protected void initView() {
        banner_Home= findViewById(R.id.banner_Home);
        tab = findViewById(R.id.tab_Home);
        pager = findViewById(R.id.pager_Home);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(new JournalismFragment());
        titles.add("学校新闻");
        fragments.add(new AchievementFragment());
        titles.add("学校成绩");
        adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
    }

    @Override
    protected int getViewId() {
        return R.layout.activity_home;
    }


    @Override
    public void success(BannBean bean) {
        banner_Home.setImages(bean.getBannerlist())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannBean.BannerlistDTO bann= (BannBean.BannerlistDTO) path;
                        Glide.with(context).load(bann.getImageurl()).into(imageView);
                    }
                })
                .start();
    }

    @Override
    public void failure(String error) {
        Log.e("TAG", "failure: "+error );
    }
}