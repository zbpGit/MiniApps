package com.chatRobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by V on 2017/9/14.
 * 收入支出控制器
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("money")
public class moneyController {



    /***
     * 我的发出接口
     * @param id  用户id
     * @return str json字符串包含（count_expend 总支出，number  所有大红包数， page_money  小红包金额，
     * page_number 小红包数量， took 已经拿了的个数， time  红包生成时间）
     */

    @RequestMapping(value = "index",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String expend(String id){

        return "";
    }


    /***
     * 我的收入接口
     * @param id  用户id
     * @return  str  json字符串包含（count_income  总收入， number  收到红包数 ， page_money  红包金额， time  领取时间）
     */

    @RequestMapping(value = "index",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String income(String id){

        return "";
    }
}

