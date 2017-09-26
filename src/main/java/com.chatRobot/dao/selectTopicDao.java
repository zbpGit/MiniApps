package com.chatRobot.dao;

import com.chatRobot.model.selectTopic;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 答题Dao层
 */
public interface selectTopicDao {

    void add(List<selectTopic> list);
    /***
     * 查找选题表
     */
    List<selectTopic> select(Integer tid);

    /***
     * 查找答案
     * @param id
     * @return
     */
    Integer answer(Integer id);
}
