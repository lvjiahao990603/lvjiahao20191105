package com.bawie.lvjiahao20191105.app;

import com.bawie.lvjiahao20191105.bean.ShowBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:11
 * function:
 */
public interface ApiServer {
    @GET("commodity/v1/commodityList")
    Observable<ShowBean> getShowData(@Header("page")String page, @Header("count")String count);
}
