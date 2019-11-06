package com.bawie.lvjiahao20191105.presenter;

import com.bawie.lvjiahao20191105.bean.ShowBean;
import com.bawie.lvjiahao20191105.contract.IHomeContract;
import com.bawie.lvjiahao20191105.model.HomeModel;

import java.lang.ref.WeakReference;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:15
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
