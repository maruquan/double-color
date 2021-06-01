package com.ma.doublecolor.utils;

public class DataFileUtils {

    public static String AnlnyData(String data){

        String splitEnd =  data.substring(data.indexOf("当前期杀号"));
        return splitEnd;
    }

}
