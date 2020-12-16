package com.example.one.contract;

public class HomeContract {
    public interface IHomeActivity<T>{
        void success(T bean);
        void failure(String error);
    }
    public interface IHomePresenter{
        void success(Object bean);
        void failure(String error);
    }
    public interface IHomeModel{
        void getData(IHomePresenter iHomePresenter);
    }
}
