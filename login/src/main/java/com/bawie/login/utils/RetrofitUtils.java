package com.bawie.login.utils;

import com.bawie.login.app.Api;
import com.bawie.login.app.ApiServer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: 吕佳豪
 * data: 2019/11/5 19:19:14
 * function:
 */
public class RetrofitUtils {
    //单例
    private static ApiServer apiServer;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitUtils(){}
    public static ApiServer getApiServer(){
        if (apiServer == null) {
            synchronized (ApiServer.class){
                if (apiServer == null) {
                    apiServer =new RetrofitUtils().getRetrofit();
                }
            }
        }
        return apiServer;
    }

    private ApiServer getRetrofit() {
        ApiServer apiServer = initRetrofit(initOKHttp()).create(ApiServer.class);
        return apiServer;
    }
    public Retrofit initRetrofit(OkHttpClient client){
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.STUDENT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public OkHttpClient initOKHttp(){
        okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(Api.TIME, TimeUnit.SECONDS)
                .connectTimeout(Api.TIME, TimeUnit.SECONDS)
                .writeTimeout(Api.TIME, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {


                    private Request request;

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        request = chain.request();
                        return chain.proceed(request);
                    }
                })
                .retryOnConnectionFailure(true)
                .build();
        return okHttpClient;
    }
}
