package com.example.one.presenter;



import com.example.one.base.BasePersenter;
import com.example.one.bean.BannBean;
import com.example.one.bean.JournalismBean;
import com.example.one.contract.HomeContract;
import com.example.one.fragment.JournalismFragment;
import com.example.one.model.HomeModel;
import com.example.one.model.JournModel;
import com.example.one.view.HomeActivity;


public class JournPersenter extends BasePersenter<JournalismFragment, JournModel> implements HomeContract.IHomePresenter {


    public JournPersenter(JournalismFragment baseView) {
        super(baseView);
    }

    @Override
    protected JournModel getBaseModel() {
        return new JournModel();
    }

    @Override
    public void getData() {
        baseModel.getData(this);
    }

    @Override
    public void success(Object bean) {
        baseView.success((JournalismBean) bean);
    }

    @Override
    public void failure(String error) {
        baseView.failure(error);
    }
}
