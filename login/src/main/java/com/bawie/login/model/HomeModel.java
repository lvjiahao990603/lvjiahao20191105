package com.bawie.login.model;

import com.bawie.login.bean.LoginBean;
import com.bawie.login.bean.RegisterBean;
import com.bawie.login.bean.ShowBean;
import com.bawie.login.bean.XbannerBean;
import com.bawie.login.contract.IHomeContract;
import com.bawie.login.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: 吕佳豪
 * data: 2019/11/5 19:19:14
 * function:
 */
public class HomeModel implements IHomeContract.Imodel {

    private Observable<LoginBean> loginBeanObservable;
    private Observer<LoginBean> observer;
    private Observable<RegisterBean> registerBeanObservable;
    private Observer<RegisterBean> observer1;
    private Observable<XbannerBean> xbannerBeanObservable;
    private Observer<XbannerBean> observer2;
    private Observable<ShowBean> showBeanObservable;
    private Observer<ShowBean> observer3;

    @Override
    public void onPostLoginData(String phone, String pwd, final IModellLoginCallback iModellLoginCallback) {
        loginBeanObservable = RetrofitUtils.getApiServer().onPostLogin(phone, pwd);
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
        registerBeanObservable = RetrofitUtils.getApiServer().onPostRegister(phone, pwd);
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
        xbannerBeanObservable = RetrofitUtils.getApiServer().onGetXbanner();
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
        showBeanObservable = RetrofitUtils.getApiServer().onGetShow(page, count);
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
}
