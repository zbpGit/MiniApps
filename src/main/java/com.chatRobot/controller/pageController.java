package com.chatRobot.controller;

import com.chatRobot.service.selectTopicService;
import com.chatRobot.service.pageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    private selectTopicService topicService;

    public void create(Map<String,Object> map){
        map.get("");
    }
}
