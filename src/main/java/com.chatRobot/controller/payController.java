package com.chatRobot.controller;

import com.chatRobot.util.PayAppUtil;
import com.chatRobot.util.PayUtil;
import com.chatRobot.util.XMLUtil;
import org.jdom.JDOMException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2017/9/27.
 */

@Controller
@RequestMapping("/pay")
public class payController {


    /**
     * 发红包
     * @param session
     * @param map
     * @return
     * @throws JDOMException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    @RequestMapping(value = "/AppPay", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String AppPay(HttpSession session, @RequestBody Map<String,	Object> map) throws JDOMException, SAXException, ParserConfigurationException, IOException {
        System.out.println(map);
        Integer money = Integer.parseInt(String.valueOf(map.get("money")));
        String openId = (String) session.getAttribute("openid");
        String pay = PayAppUtil.Pay(openId, money,"商户订单号","https://miniapp.qingmeng168.com/RedPage/pay/syntony");
        return pay;
    }

    /**
     * 支付回调
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/syntony", produces = "text/html;charset=UTF-8")
    public void syntony(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String resXml = null;
        //读取参数
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null) {
            sb.append(s);
        }
        in.close();
        inputStream.close();
        System.out.println("回调参数="+sb.toString());
        //解析xml成map
        Map<String, Object> m = new HashMap<String, Object>();
        m = XMLUtil.doXMLParse(sb.toString());

        //过滤空 设置 TreeMap
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = (String) m.get(parameter);
            String v = "";
            if (null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
        // 账号信息
        String key = "key"; // key
        //判断签名是否正确
        if (PayUtil.isTenpaySign("UTF-8", packageParams, key)) {
            //------------------------------
            //处理业务开始
            //------------------------------
            try {
                if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
                    String  success = null;
                    // 这里是支付成功，返回参数
                    resXml = setXml("SUCCESS", "OK");
                    //////////执行自己的业务逻辑////////////////
                    String out_trade_no = (String) packageParams.get("out_trade_no");



                }else {
                    resXml =  setXml("fail", "微信返回的交易状态不正确（result_code=" + "SUCCESS" + "）");
                }
            }catch (Exception e){
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } else {
            resXml =  setXml("fail", "签名失败");
        }
        //------------------------------
        //处理业务完毕
        //------------------------------
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }


    /**
     *企业打款
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    @RequestMapping(value = "/remittance", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String remittance() throws ParserConfigurationException, SAXException, IOException {
        return PayAppUtil.AppRemit();
    }


    /**
     * 给微信返回参数
     * @param return_code
     * @param return_msg
     * @return
     */
    public static String setXml(String return_code, String return_msg) {
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("return_code", return_code);
        parameters.put("return_msg", return_msg);
        return "<xml><return_code><![CDATA[" + return_code + "]]>" +
                "</return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
    }

}
