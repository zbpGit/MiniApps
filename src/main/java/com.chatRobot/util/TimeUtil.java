package com.chatRobot.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by V on 2017/9/16.
 * 时间工具类
 */
public class TimeUtil {

    public static String getTimeStamp(){
        String str=String.valueOf(System.currentTimeMillis());
        return str;
    }

    /***
     * 返回年月日时分秒
     * @return
     */
    public static String getTime(){
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String hehe = df.format(now);
       return hehe;
    }
}
