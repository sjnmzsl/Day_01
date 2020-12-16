package com.example.one.presenter;



import com.example.one.base.BasePersenter;
import com.example.one.bean.BannBean;
import com.example.one.contract.HomeContract;
import com.example.one.model.HomeModel;
import com.example.one.view.HomeActivity;


public class HomePersenter extends BasePersenter<HomeActivity,HomeModel> implements HomeContract.IHomePresenter {


    public HomePersenter(HomeActivity baseActivity) {
        super(baseActivity);
    }

    @Override
    protected HomeModel getBaseModel() {
        return new HomeModel();
    }

    @Override
    public void getData() {
        baseModel.getData(this);
    }


    @Override
    public void success(Object bean) {
        baseView.success((BannBean) bean);
    }

    @Override
    public void failure(String error) {

    }
}
