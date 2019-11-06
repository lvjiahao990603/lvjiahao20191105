package com.bawie.lvjiahao20191105.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.bawie.lvjiahao20191105.app.Api;
import com.bawie.lvjiahao20191105.app.ApiServer;

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
 * data: 2019/11/5 09:9:12
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
    public boolean isConnectIsNomarl() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            String intentName = info.getTypeName();
            Log.i("通了没！", "当前网络名称：" + intentName);
            return true;
        } else {
            Log.i("通了没！", "没有可用网络");
            return false;
        }
    }

    private Context getApplicationContext() {
        return null;
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
