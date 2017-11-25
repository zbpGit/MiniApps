package com.zbp.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.zbp.util.HttpRequester;
import com.zbp.util.Md5;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/9/25.
 */
public class PayController extends Controller{

    public void index(){
        SortedMap<String,Object> map = new TreeMap<String,Object>();
        map.put("mch_appid", "1111111111");//公众账号I
        map.put("mchid", "111111111111");//商户号
        map.put("nonce_str", Md5.create_RandomString(32));//随机字符串
        map.put("partner_trade_no",Md5.create_RandomString(32));//商户订单号
        map.put("openid",Md5.create_RandomString(32));//openid
        map.put("check_name","NO_CHECK");//校验用户姓名选项
        map.put("amount","200");
        map.put("desc","红包");//企业付款描述信息
        map.put("spbill_create_ip","127.0.0.1");//Ip地址
        String sign=Md5.sign(map);
        map.put("sign",sign);//签名
        //封装成xml
        String xml = Md5.ArrayToXml(map);
        String xx= HttpRequester.sendPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers",xml);
        renderText(xx);
    }

}
