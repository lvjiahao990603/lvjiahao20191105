package com.bawie.login.app;

import android.app.Application;
import android.content.Context;

/**
 * author: 吕佳豪
 * data: 2019/11/5 18:18:53
 * function:
 */
public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
