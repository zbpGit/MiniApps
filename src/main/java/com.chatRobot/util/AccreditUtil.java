package com.chatRobot.util;

import net.sf.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by V on 2017/9/20.
 * 小程序授权
 */
public class AccreditUtil {

    public static void accredit(String code){
        String http="api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        String json=HttpRequester.sendGet(http);
        JSONObject jasonObject=JSONObject.fromObject(json);
        Map<String,Object> map=(Map)jasonObject;

    }
}
