package com.example.one.presenter;



import com.example.one.base.BasePersenter;
import com.example.one.bean.AchievementBean;
import com.example.one.bean.JournalismBean;
import com.example.one.contract.HomeContract;
import com.example.one.fragment.AchievementFragment;
import com.example.one.fragment.JournalismFragment;
import com.example.one.model.AchieModel;
import com.example.one.model.JournModel;


public class AchiePersenter extends BasePersenter<AchievementFragment, AchieModel> implements HomeContract.IHomePresenter {


    public AchiePersenter(AchievementFragment baseView) {
        super(baseView);
    }

    @Override
    protected AchieModel getBaseModel() {
        return new AchieModel();
    }


    @Override
    public void getData() {
        baseModel.getData(this);
    }


    @Override
    public void success(Object bean) {
        baseView.success((AchievementBean) bean);
    }

    @Override
    public void failure(String error) {
        baseView.failure(error);
    }
}
