package com.chatRobot.controller;

import com.chatRobot.util.PayAppUtil;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/27.
 */
public class payController {

    @RequestMapping(value = "/AppPay", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String payment(HttpSession session, @RequestBody Map<String,	Object> map){
        String error = "0";
        System.out.println(map);
        Integer money = Integer.parseInt(String.valueOf(map.get("money")));
        String openId = (String) session.getAttribute("openid");
        //String pay = PayAppUtil.Pay(openId, money,out_trade_no,IntimityUtil.payTwe);
        return "";
    }

}
