package com.bawie.a1106.model;

import com.bawie.a1106.bean.LoginBean;
import com.bawie.a1106.bean.RegisterBean;
import com.bawie.a1106.bean.ShopBean;
import com.bawie.a1106.bean.ShowBean;
import com.bawie.a1106.bean.XbannerBean;
import com.bawie.a1106.contract.IHomeContract;
import com.bawie.a1106.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: 吕佳豪
 * data: 2019/11/6 08:8:53
 * function:
 */
public class HomeModel implements IHomeContract.Imodel {

    private Observer<LoginBean> observer;
    private Observer<RegisterBean> observer1;
    private Observer<XbannerBean> observer2;
    private Observer<ShowBean> observer3;
    private Observable<ShopBean> shopBeanObservable;
    private Observer<ShopBean> observer4;

    @Override
    public void onPostLoginData(String phone, String pwd, final IModellLoginCallback iModellLoginCallback) {
        Observable<LoginBean> loginBeanObservable = RetrofitUtils.getApiServer().onPostLogin(phone, pwd);
        observer = new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                iModellLoginCallback.onSuccess(loginBean);
            }

            @Override
            public void onError(Throwable e) {
                iModellLoginCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        loginBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onPostRegisterData(String phone, String pwd, final IModelRegisterCallback iModelRegisterCallback) {
        Observable<RegisterBean> registerBeanObservable = RetrofitUtils.getApiServer().onPostRegister(phone, pwd);
        observer1 = new Observer<RegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterBean registerBean) {
                iModelRegisterCallback.onSuccess(registerBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelRegisterCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        registerBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer1);
    }

    @Override
    public void onGetXbannerData(final IModelXbannerCallback iModelXbannerCallback) {
        Observable<XbannerBean> xbannerBeanObservable = RetrofitUtils.getApiServer().onGetXbanner();
        observer2 = new Observer<XbannerBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XbannerBean xbannerBean) {
                iModelXbannerCallback.onSuccess(xbannerBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelXbannerCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        xbannerBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }

    @Override
    public void onGetShowData(String page, String count, final IModelCallback iModelCallback) {
        Observable<ShowBean> showBeanObservable = RetrofitUtils.getApiServer().onGetShow(page, count);
        observer3 = new Observer<ShowBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ShowBean showBean) {
                iModelCallback.onSuccess(showBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        showBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer3);
    }

    @Override
    public void onGetShopData(String userId, String sessionId, final IModelShopCallback iModelShopCallback) {
        shopBeanObservable = RetrofitUtils.getApiServer().onGetShop(userId, sessionId);
        observer4 = new Observer<ShopBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ShopBean shopBean) {
                iModelShopCallback.onSuccess(shopBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelShopCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        shopBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer4);
    }
}
