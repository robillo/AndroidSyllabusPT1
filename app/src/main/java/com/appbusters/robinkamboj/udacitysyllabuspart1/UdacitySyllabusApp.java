package com.appbusters.robinkamboj.udacitysyllabuspart1;

import android.app.Application;
import android.content.Context;

public class UdacitySyllabusApp extends Application{

    private static Context sContext;

    @Override
    public void onCreate() {
        sContext = getApplicationContext();
        super.onCreate();
    }

    public static Context getAppContext() {
        return sContext;
    }
}
