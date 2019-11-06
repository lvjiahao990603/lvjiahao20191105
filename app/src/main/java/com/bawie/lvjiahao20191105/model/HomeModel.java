package com.bawie.lvjiahao20191105.model;

import com.bawie.lvjiahao20191105.bean.ShowBean;
import com.bawie.lvjiahao20191105.contract.IHomeContract;
import com.bawie.lvjiahao20191105.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:13
 * function:
 */
public class HomeModel implements IHomeContract.Imodel {

    private Observer<ShowBean> observer;

    @Override
    public void onGetShowData(String page, String count, final IModelCallback iModelCallback) {
        Observable<ShowBean> showBeanObservable = RetrofitUtils.getApiServer().getShowData(page, count);
        observer = new Observer<ShowBean>() {
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
                .subscribe(observer);
    }
}
