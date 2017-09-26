package com.chatRobot.service;

import com.chatRobot.model.answer;
import com.chatRobot.model.topic;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 题目服务层
 */
public interface topicService {
    /***
     * 查找题目
     * @param map
     * @return
     */
    List<topic> select(Map<String, Object> map);

    /***
     * 查找答案
     * @param id
     * @return
     */
    List<answer> selectAnswer(Integer id);

    /***
     * 查找题目跟正确答案
     * @param map
     * @return
     */
    List<topic> selectResponse(Map<String, Object> map);

    topic selectone(Integer id);
}
