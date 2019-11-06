package com.bawie.a1106.app;


import com.bawie.a1106.bean.LoginBean;
import com.bawie.a1106.bean.RegisterBean;
import com.bawie.a1106.bean.ShopBean;
import com.bawie.a1106.bean.ShowBean;
import com.bawie.a1106.bean.XbannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * author: 吕佳豪
 * data: 2019/11/6 08:8:48
 * function:
 */
public interface ApiServer {
    @POST("user/v1/login")
    Observable<LoginBean> onPostLogin(@Query("phone")String phone, @Query("pwd")String pwd);
    @POST("user/v1/register")
    Observable<RegisterBean> onPostRegister(@Query("phone")String phone, @Query("pwd")String pwd);
    @GET("commodity/v1/commodityList")
    Observable<ShowBean> onGetShow(@Header("page")String page, @Header("count")String count);
    @GET("commodity/v1/bannerShow")
    Observable<XbannerBean> onGetXbanner();
    @GET("order/verify/v1/findShoppingCart")
    Observable<ShopBean>onGetShop(@Header("userId")String userId,@Header("sessionId")String sessionId);
}
