package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.UdacitySyllabusApp;

public class SharedPrefs{

    private static final String IS_TOGGLE_TRUE = "true_or_false_toggle";

    private static SharedPreferences getPreferences(){
        Context context = UdacitySyllabusApp.getAppContext();
        return  context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static void setIsToggleTrue(String token){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(IS_TOGGLE_TRUE, token);
        editor.apply();
    }

    public static String getIsToggleTrue() {
        return SharedPrefs.getPreferences().getString(IS_TOGGLE_TRUE, null);
    }

}
