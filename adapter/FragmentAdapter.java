package com.example.one.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> arr;
    private ArrayList<String> titles;

    public FragmentAdapter(@NonNull FragmentManager fm,ArrayList<Fragment> arr,
           ArrayList<String> titles) {
        super(fm);
        this.arr=arr;
        this.titles=titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arr.get(position);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
