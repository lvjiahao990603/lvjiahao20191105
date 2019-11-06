package com.bawie.login.contract;

import com.bawie.login.bean.LoginBean;
import com.bawie.login.bean.RegisterBean;
import com.bawie.login.bean.ShowBean;
import com.bawie.login.bean.XbannerBean;

/**
 * author: 吕佳豪
 * data: 2019/11/5 19:19:01
 * function:
 */
public interface IHomeContract {
    //view interface
    interface Iview{
        //登录
        void onHomePostLoginSuccess(LoginBean data);
        void onHomePostLoginFailure(String e);
        //注册
        void onHomePostRegisterSuccess(RegisterBean data);
        void onHomePostRegisterFailure(String e);
        //Xbanner
        void onHomeGetXbannerSuccess(XbannerBean data);
        void onHomeGetXbannerFailure(String e);
        //展示
        void onHomeGetShowSuccess(ShowBean data);
        void onHomeGetShowFailure(String e);
    }
    //model interface
    interface Imodel{
        //登录
        void onPostLoginData(String phone,String pwd,IModellLoginCallback iModellLoginCallback);
        //注册
        void onPostRegisterData(String phone,String pwd,IModelRegisterCallback iModelRegisterCallback);
        //Xbanner
        void onGetXbannerData(IModelXbannerCallback iModelXbannerCallback);
        //展示
        void onGetShowData(String page,String count,IModelCallback iModelCallback);
        //登录
        interface IModellLoginCallback{
            void onSuccess(LoginBean data);
            void onFailure(String e);
        }
        //注册
        interface IModelRegisterCallback{
            void onSuccess(RegisterBean data);
            void onFailure(String e);
        }
        //Xbanner
        interface IModelXbannerCallback{
            void onSuccess(XbannerBean data);
            void onFailure(String e);
        }
        //展示
        interface IModelCallback{
            void onSuccess(ShowBean data);
            void onFailure(String e);
        }
    }
    //presenter interface
    interface Ipresenter{
        void attachView(IHomeContract.Iview view);
        void detachView();
        //登录
        void postLoginPresenter(String phone,String pwd);
        //注册
        void postRegisterPresenter(String phone,String pwd);
        //Xbanner
        void getXbannerPresenter();
        //展示
        void getShowPresenter(String page,String count);
    }
}
