package com.bawie.a1106.app;

import android.app.Application;
import android.content.Context;

/**
 * author: 吕佳豪
 * data: 2019/11/6 08:8:46
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
