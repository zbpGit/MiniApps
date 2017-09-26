package com.chatRobot.dao;

import com.chatRobot.model.response;
import com.chatRobot.model.selectTopic;

import java.util.List;

/**
 * Created by V on 2017/9/21.
 * 答题Dao层
 */
public interface responseDao {
    void add(List<response> list);
    Integer select(selectTopic topic);
    Integer count(response response);

}
