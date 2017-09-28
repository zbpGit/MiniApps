package com.chatRobot.controller;

import com.chatRobot.model.income;
import com.chatRobot.model.page;
import com.chatRobot.service.incomeService;
import com.chatRobot.service.pageService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by V on 2017/9/14.
 * 收入支出控制器
 */

@Controller
@RequestMapping("money")
public class moneyController {
    @Resource
    private incomeService inService;
    @Resource
    private pageService paService;
/***
     * 我的发出接口
     * @param id  用户id
     * @return str json字符串包含（count_expend 总支出，number  所有大红包数， page_money  小红包金额，
     * page_number 小红包数量， took 已经拿了的个数， time  红包生成时间）
     */

    @RequestMapping(value = "expend",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String expend(String id){
        List<page> list=paService.pageSelect(Integer.parseInt(id));
        int number=0;
        int count=0;
        int draw=0;
        for (page pa:list){
            draw=pa.getPage_number()-pa.getResidue();
            pa.setResidue(draw);
            count=pa.getPage_money()+count;
            number=number+1;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        map.put("number",number);
        map.put("count",count);
        Gson gson=new Gson();
        String str=gson.toJson(map);
        return str;
    }


/***
     * 我的收入接口
     * @param id  用户id
     * @return  str  json字符串包含（count_income  总收入， number  收到红包数 ， page_money  红包金额， time  领取时间）
     */

    @RequestMapping(value = "income",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String income(String id){
        List<income> list=inService.userIncome(Integer.parseInt(id));
        int a=0;
        int count=0;
        for(income i:list){
            i.setHeadline(paService.headline(i.getPid()));
            System.out.println(i.getTime());
            count=i.getIncome_money()+count;
            a=a+1;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("count",count);
        map.put("number",a);
        map.put("list",list);
        Gson gson=new Gson();
        String str=gson.toJson(map);
        return str;
    }
}

