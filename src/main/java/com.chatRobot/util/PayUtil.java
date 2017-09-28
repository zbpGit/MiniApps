package com.chatRobot.util;


import org.jdom.JDOMException;
import org.junit.Test;

import java.io.IOException;
import java.util.*;


/**
 * Created by V on 2017/9/18.
 */

public class PayUtil {


/***
     * 支付API
     * @return Map 返回map
     */

    public Map<String, Object> pay(){
        Map<String,Object> indentMap=indent();
        Map<String,Object> map=new TreeMap<>();
        String time=TimeUtil.getTimeStamp();
        String nonceStr=PayUtil.create_RandomString(32);
        map.put("timeStamp",time);//时间戳
        map.put("nonceStr",nonceStr);//随机字符串
        map.put("package",indentMap.get("prepay_id"));
        //调用统一下单，返回Map,从Map里获取prepay_id值
        map.put("signType","MD5");//签名方式
        String paySign=PayUtil.sign(map);//生成签名
        map.put("paySign",paySign);//签名
        return map;
    }


/***
     * 统一下单
     */


    public Map<String, Object> indent(){
        Map<String,Object> map=new TreeMap<>();
        map.put("appid","appid");//公众账号ID
        map.put("mch_id","mch_id");//商户号
        map.put("body","body");//商品描述
        map.put("nonce_str",PayUtil.create_RandomString(32));//随机字符串
        System.out.println(map.toString());
        //生成订单号
        String Str=PayUtil.create_RandomString(18);
        String time=TimeUtil.getTime();
        String out_trade_no=time+Str;
        map.put("out_trade_no",out_trade_no);//订单号
        map.put("total_fee","10");//订单总金额
        map.put("spbill_create_ip","39.108.50.139");//终端IP
        map.put("notify_url","http://www.qingmeng168.com:8081/ChatRobot/index1.jsp");//回调地址
        map.put("trade_type","JSAPI");//交易类型
        String sign=PayUtil.sign(map);
        map.put("sign",sign);//签名
        String xml=XMLUtil2.ArrayToXml(map);
        System.out.println(xml);
        String str=HttpRequester.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder",xml);
        Map<String,Object> map1=new HashMap<>();
        try {
            map1=XMLUtil.doXMLParse(str);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map1;
    }

    /***
     * 企业打款
     */
    public void remit(){
        Map<String,Object> map=new TreeMap<>();
        map.put("mch_appid","appid");//商户账号appid
        map.put("mchid","mchid");//商户号
        map.put("nonce_str",PayUtil.create_RandomString(32));//随机字符串
        String time=TimeUtil.getTime();
        String Str=PayUtil.create_Number(18);
        String partner_trade_no=time+Str;
        map.put("partner_trade_no",partner_trade_no);
        map.put("openid","openid");

    }


/***
     * 生成sign
     * @param map
     * @return
     */

    public static String sign(Map<String,Object> map){
        StringBuffer sb=new StringBuffer();
        Set es=map.entrySet();
        Iterator it=es.iterator();
        String k;
        String v;
        while (it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            k=(String)entry.getKey();
            v=(String)entry.getValue();
            sb.append(k+"="+v+"&");
        }
        sb.append("key="+"key");
        String paySign=MD5Util.MD5Encode(sb.toString(),null).toUpperCase();
        return paySign;
    }

    public static String create_RandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }



    public static String create_Number(int length) { //length表示生成字符串的长度
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     *
     * @param characterEncoding
     * @param packageParams
     * @param API_KEY
     * @return
     */
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }

        sb.append("key=" + API_KEY);

        //算出摘要
        String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();
        return tenpaySign.equals(mysign);
    }
}

