package com.testdemo.pinkcommunityuia;

import android.app.Application;
import android.content.Context;

public class ContextUtil extends Application {


    private static ContextUtil instance;
    public Context context;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        this.context = this;
    }
}