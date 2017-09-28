package com.chatRobot.util;

import com.google.gson.Gson;
import org.jdom.JDOMException;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/9/27.
 */
public class PayAppUtil {

    /**
     *
     * @param openid    openid
     * @param money 金额
     * @param out_trade_no  随机数
     * @param payTwo    回调字段
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws JDOMException
     */
    public static String Pay(String openid,Integer money,String out_trade_no,String payTwo) throws IOException, SAXException, ParserConfigurationException, JDOMException {
        //下单
        Gson gson =new Gson();
        String sum = moeny(money);
        SortedMap<String,Object> map = new TreeMap<String,Object>();
        map.put("appid", "");//公众账号ID
        map.put("mch_id","");//商户号
        map.put("attach", "我包你答");//附加数据
        map.put("nonce_str", PayUtil.create_RandomString(32));//随机字符串
        map.put("body","红包");//商品描述
        map.put("out_trade_no",out_trade_no);//商户订单号
        map.put("total_fee",sum);//金额
        map.put("notify_url",payTwo);//通知地址
        map.put("trade_type","JSAPI");//交易类型
        map.put("openid",openid);//openid
        String mySign = PayUtil.sign(map);
        map.put("sign",mySign);//签名
        //封装成xml
        String xml = XMLUtil2.ArrayToXml(map);
        String str= HttpRequester.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder",xml);
        //获取prepay_id
        Map map1 =XMLUtil.doXMLParse(str);
        String prepay_id=(String) map1.get("prepay_id");
        String prepay = "prepay_id="+prepay_id;
        String nonce_str = PayUtil.create_RandomString(32);
        String timeStamp = PayUtil.create_timestamp();
        //提交订单
        SortedMap<String,Object> sortedMap = new TreeMap<String,Object>();
        sortedMap.put("appId","");
        sortedMap.put("timeStamp",timeStamp);
        sortedMap.put("nonceStr",nonce_str);
        sortedMap.put("package",prepay);
        sortedMap.put("signType","MD5");
        String paySign = PayUtil.sign(sortedMap);
        sortedMap.put("paySign",paySign);
        String pay = gson.toJson(sortedMap);
        return pay;
    }

    /**
     * 企业打款
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static String AppRemit() throws IOException, SAXException, ParserConfigurationException {
        SortedMap<String,Object> map = new TreeMap<String,Object>();
        map.put("mch_appid", "1111111111");//公众账号I
        map.put("mchid", "111111111111");//商户号
        map.put("nonce_str", PayUtil.create_RandomString(32));//随机字符串
        map.put("partner_trade_no",PayUtil.create_RandomString(32));//商户订单号
        map.put("openid",PayUtil.create_RandomString(32));//openid
        map.put("check_name","NO_CHECK");//校验用户姓名选项
        map.put("amount","200");
        map.put("desc","红包");//企业付款描述信息
        map.put("spbill_create_ip","127.0.0.1");//Ip地址
        String sign=PayUtil.sign(map);
        map.put("sign",sign);//签名
        //封装成xml
        String xml = XMLUtil2.ArrayToXml(map);
        String xx= HttpRequester.sendPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers",xml);
        Map<String,Object> xm = XMLUtil2.getMapFromXML(xx);
        if (map.get("result_code") == "SUCCESS" && map.get("return_code") =="SUCCESS"){
            return "SUCCESS";
        }else {
            return "FAIL";
        }
    }

    /**
     *金额
     * @param money
     * @return
     */
    public static String moeny(Integer money){
        String sum = String.valueOf(money*100);
        return sum;
    }

    @Test
    public void iii(){
        Set<String> roles = new HashSet<String>();
        roles.add("1");
        System.out.println(roles);
    }



}
