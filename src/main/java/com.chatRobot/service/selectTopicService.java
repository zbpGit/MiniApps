package com.chatRobot.service;

import com.chatRobot.model.selectTopic;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 选题服务层抽象类
 */
public interface selectTopicService {
    /***
     * 添加已选题目
     * @param list
     */
    void add(List<selectTopic> list);

    /***
     * 查找选题表
     * @param tid
     * @return
     */
    List<selectTopic> select(Integer tid);

    /***
     * 查找答案
     * @param id
     * @return
     */
    Integer answer(Integer id);
}
