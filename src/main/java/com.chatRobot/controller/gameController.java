package com.chatRobot.controller;


import com.chatRobot.model.game;
import com.chatRobot.service.gameService;

import com.google.gson.Gson;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by V on 2017/9/11.
 * 玩法控制器
 */
@Controller
@RequestMapping("game")
public class gameController {

   // private static Logger logger = org.apache.log4j.Logger.getLogger(gameController.class);

    @Resource
    private gameService service;

    /***
     * 玩法接口
     * @return str  json字符串包含（rule_headline  玩法标题，content  玩法内容）
     */
    @RequestMapping(value = "select",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String select(){
      /*
        try {

        }catch (Exception e){
            logger.error("出现错误",new Exception(e));
        }*/
      //  logger.info("进入玩法接口");
       Gson gson=new Gson();
        List<game> list=service.select();
        System.out.println(gson.toJson(list));
     //   logger.info("退出玩法接口");
        return gson.toJson(list);
    }

    /**
     * 打开首页接口
     * @return  str  json字符串包含（condition  答对多少题才有红包， service 服务费）
     */
  /*  @RequestMapping(value = "index",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String index(){
        Gson gson=new Gson();
        Map mao=new HashMap<String,Object>();
        mao.put("condition",5);
        mao.put("service",10);
        String str=gson.toJson(mao);
        System.out.println(str.toString());
        return str.toString();
    }*/
}
