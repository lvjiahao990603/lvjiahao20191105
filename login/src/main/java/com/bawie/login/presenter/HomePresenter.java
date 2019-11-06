package com.bawie.login.presenter;

import com.bawie.login.bean.LoginBean;
import com.bawie.login.bean.RegisterBean;
import com.bawie.login.bean.ShowBean;
import com.bawie.login.bean.XbannerBean;
import com.bawie.login.contract.IHomeContract;
import com.bawie.login.model.HomeModel;

import java.lang.ref.WeakReference;

/**
 * author: 吕佳豪
 * data: 2019/11/5 19:19:20
 * function:
 */
public class HomePresenter implements IHomeContract.Ipresenter {

    private HomeModel homeModel;
    private WeakReference<IHomeContract.Iview> viewWeakReference;

    @Override
    public void attachView(IHomeContract.Iview view) {
        homeModel = new HomeModel();
        viewWeakReference = new WeakReference<>((IHomeContract.Iview) view);
    }
    public IHomeContract.Iview getView(){
        return viewWeakReference.get();
    }

    @Override
    public void detachView() {
        if (viewWeakReference!=null){
            viewWeakReference.clear();
            viewWeakReference=null;
        }
    }

    @Override
    public void postLoginPresenter(String phone, String pwd) {
        homeModel.onPostLoginData(phone, pwd, new IHomeContract.Imodel.IModellLoginCallback() {
            @Override
            public void onSuccess(LoginBean data) {
                getView().onHomePostLoginSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomePostLoginFailure(e);
            }
        });
    }

    @Override
    public void postRegisterPresenter(String phone, String pwd) {
        homeModel.onPostRegisterData(phone, pwd, new IHomeContract.Imodel.IModelRegisterCallback() {
            @Override
            public void onSuccess(RegisterBean data) {
                getView().onHomePostRegisterSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomePostRegisterFailure(e);
            }
        });
    }

    @Override
    public void getXbannerPresenter() {
        homeModel.onGetXbannerData(new IHomeContract.Imodel.IModelXbannerCallback() {
            @Override
            public void onSuccess(XbannerBean data) {
                getView().onHomeGetXbannerSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetXbannerFailure(e);
            }
        });
    }

    @Override
    public void getShowPresenter(String page, String count) {
        homeModel.onGetShowData(page, count, new IHomeContract.Imodel.IModelCallback() {
            @Override
            public void onSuccess(ShowBean data) {
                getView().onHomeGetShowSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetShowFailure(e);
            }
        });
    }
}
