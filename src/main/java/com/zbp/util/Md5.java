package com.zbp.util;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/25.
 */
public class Md5 {

    /**
     * 生成随机数
     * @param length
     * @return
     */
    public static String create_RandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * map转成xml
     *
     * @param arr
     * @return
     */
    public static String ArrayToXml(Map arr) {
        String xml = "<xml>";

        Iterator<Map.Entry<String, String>> iter = arr.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String val = entry.git getValue();
            xml += "<" + key + ">" + val + "</" + key + ">";
        }

        xml += "</xml>";
        return xml;
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
            System.out.println("---------"+k);
            v=(String)entry.getValue();
            sb.append(k+"="+v+"&");
        }
        sb.append("key="+"key");
        String paySign=Md5.MD5Encode(sb.toString(),null).toUpperCase();
        return paySign;
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };



}
