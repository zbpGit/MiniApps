package com.chatRobot.dao;

import com.chatRobot.model.answer;
import com.chatRobot.model.topic;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 题目Dao层
 */
public interface topicDao {
    List<topic> select(Map<String, Object> map);
    List<answer> selectAnswer(Integer id);
    List<topic> selectResponse(Map<String, Object> map);
    topic selectone(Integer id);
}
