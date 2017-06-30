package com.appbusters.robinkamboj.udacitysyllabuspart1.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.appbusters.robinkamboj.udacitysyllabuspart1.UdacitySyllabusApp;

public class SharedPrefs{

    private static final String IS_TOGGLE_TRUE = "true_or_false_toggle";
    private static final String IS_LANGUAGE_SET = "true_or_false_language";

    private static SharedPreferences getPreferences(){
        Context context = UdacitySyllabusApp.getAppContext();
        return  context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    /*....................................................................................*/

    public static void setIsToggleTrue(String token){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(IS_TOGGLE_TRUE, token);
        editor.apply();
    }

    public static String getIsToggleTrue() {
        return SharedPrefs.getPreferences().getString(IS_TOGGLE_TRUE, null);
    }

    public static void setIsLanguageSet(String token){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(IS_LANGUAGE_SET, token);
        editor.apply();
    }

    public static String getIsLanguageSet(){
        return SharedPrefs.getPreferences().getString(IS_LANGUAGE_SET, null);
    }
}
