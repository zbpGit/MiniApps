package com.chatRobot.controller;

import com.chatRobot.model.page;
import com.chatRobot.model.user;
import com.chatRobot.service.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 红包控制层
 */
@RequestMapping("page")
@Controller
public class pageController {
    @Resource
    private pageService service;
    @Resource
    private userService usService;
    @Resource
    private configService conService;
    @Resource
    private selectTopicService topicService;
    @Resource
    private incomeService inService;
    @Resource
    private privityService prService;

    @RequestMapping(value="index",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String index(@RequestBody Map<String,Object> map) {
        String openid = (String) map.get("openid");
        Gson gson = new Gson();
        String number=conService.select("service");
        Map<String,Object> map1=new HashMap<>();
        map1.put("service",number);
        Integer id = usService.selectUser(openid);
        if (id == null) {
            String name = (String) map.get("name");
            String sex = (String) map.get("sex");
            String head = (String) map.get("head");
            user us = new user();
            us.setName(name);
            us.setSex(sex);
            us.setHead(head);
            us.setOpenid(openid);
            us.setCount_expend(0);
            us.setCount_income(0);
            usService.add(us);
            map1.put("id",us.getId());
            return gson.toJson(map1);
        } else {
            map1.put("id",id);
            return gson.toJson(map1);
        }
    }

    /***
     * 红包详情
     * @param id 红包id
     * @return
     */
    @RequestMapping(value="record",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String record(Integer id){
        page pa=service.selectNumber(id);
        pa.setResidue(pa.getPage_number()-pa.getResidue());
        List<user> list=inService.selectUser(id);
        Map<String,Object> map=new HashMap();
        map.put("page",pa);
        map.put("userList",list);
        Gson gson=new Gson();
        return gson.toJson(map);
    }

    @RequestMapping(value="privity",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String tacit(@RequestBody Map<String,Object> map){
        String id=(String)map.get("id");
        prService.rank(Integer.parseInt(id));
        return "";
    }


}
