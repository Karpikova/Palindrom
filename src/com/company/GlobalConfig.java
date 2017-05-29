package com.company;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 29.05.2017
 * 
 * Karpikova
 */
public class GlobalConfig {

    private static int max = 1;

    public static int getMax() {
        return max;
    }

    public static void setMax(int max) {
        GlobalConfig.max = max;
    }
}
