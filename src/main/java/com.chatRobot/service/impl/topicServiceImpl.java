package com.chatRobot.service.impl;

import com.chatRobot.dao.topicDao;
import com.chatRobot.model.answer;
import com.chatRobot.model.topic;
import com.chatRobot.service.topicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 题目服务层实现类
 */
@Service
public class topicServiceImpl implements topicService {
    @Resource
    private topicDao dao;

    /***
     * 查找题目
     * @param map
     * @return
     */
    @Override
    public List<topic> select(Map<String,Object> map) {
        return dao.select(map);
    }

    /***
     * 查找答案
     * @param id
     * @return
     */
    @Override
    public List<answer> selectAnswer(Integer id) {
        return dao.selectAnswer(id);
    }

    /***
     * 查找题目跟正确答案
     * @param map
     * @return
     */
    @Override
    public List<topic> selectResponse(Map<String, Object> map) {
        return dao.selectResponse(map);
    }

    @Override
    public topic selectone(Integer id) {
        return dao.selectone(id);
    }


}
