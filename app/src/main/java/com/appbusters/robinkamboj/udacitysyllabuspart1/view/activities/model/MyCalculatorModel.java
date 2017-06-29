package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model;

public class MyCalculatorModel {
    public static int add(int a, int b){
        return a+b;
    }

    public static int subtract(int a, int b){
        return a-b;
    }

    public static String divide(int a, int b){
        if(a==0 && b==0){
            return "NOT DEFINED";
        }
        else if(b==0){
            return "INFINITY";
        }
        else {
            return String.valueOf(a/b);
        }
    }
}
