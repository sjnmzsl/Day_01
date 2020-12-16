package com.example.one.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.example.one.R;
import com.example.one.adapter.RecyAdapter_AchieFra;
import com.example.one.adapter.RecyAdapter_JournFra;
import com.example.one.base.BaseFragment;
import com.example.one.bean.AchievementBean;
import com.example.one.bean.JournalismBean;
import com.example.one.contract.HomeContract;
import com.example.one.presenter.AchiePersenter;
import com.example.one.presenter.JournPersenter;

import java.util.ArrayList;

public class AchievementFragment extends BaseFragment<AchiePersenter> implements HomeContract.IHomeActivity<AchievementBean> {


    private RecyclerView recy;
    private FragmentActivity activity;
    private ArrayList<AchievementBean.StudenlistDTO> arr;
    private RecyAdapter_AchieFra adapter;


    @Override
    protected AchiePersenter getPresenter() {
        return new AchiePersenter(this);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        activity = getActivity();
        arr = new ArrayList<>();
        recy = view.findViewById(R.id.recy_JournFra);
        recy.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new RecyAdapter_AchieFra(activity, arr);
        recy.setAdapter(adapter);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_journalism;
    }

    @Override
    public void success(AchievementBean bean) {
        arr.addAll(bean.getStudenlist());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failure(String error) {
        Log.e("TAG", "failure: "+error );
    }
}