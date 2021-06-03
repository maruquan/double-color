package com.ma.doublecolor.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    public final static String ELAPSE_TIME="，耗时：{}ms";
    public static Logger get(){
        StackTraceElement[] stackTrace=Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTrace[2].getClassName());
    }
}
