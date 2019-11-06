package com.bawie.lvjiahao20191105.contract;

import com.bawie.lvjiahao20191105.bean.ShowBean;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:07
 * function:契约类
 */
public interface IHomeContract {
    //view interface
    interface Iview{
        //成功
        void onHomeGetShowSuccess(ShowBean data);
        //失败
        void onHomeGetShowFailure(String e);
    }
    //model interface
    interface Imodel{
        //定义
        void onGetShowData(String page,String count,IModelCallback iModelCallback);
        interface IModelCallback{
            //成功
            void onSuccess(ShowBean data);
            //失败
            void onFailure(String e);
        }
    }
    //presenter interface
    interface Ipresenter{
        //绑定
        void attachView(IHomeContract.Iview view);
        //解绑
        void detachView();
        //展示
        void getShowPresenter(String page,String count);
    }
}
