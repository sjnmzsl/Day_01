package com.example.one.base;

public abstract class BasePersenter<V,M>  {
    protected V baseView;
    protected M baseModel;
    public BasePersenter(V baseView) {
        this.baseView = baseView;
        baseModel=getBaseModel();
    }
    protected abstract M getBaseModel();
    protected abstract void getData();

}
