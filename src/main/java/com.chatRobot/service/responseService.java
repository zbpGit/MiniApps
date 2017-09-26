package com.chatRobot.service;

import com.chatRobot.model.response;
import com.chatRobot.model.selectTopic;

import java.util.List;

/**
 * Created by V on 2017/9/21.
 * 答题服务层
 */
public interface responseService {
    /***
     * 提交答题
     * @param list
     */
    void add(List<response> list);

    /***
     * 查找答案
     * @param
     * @return
     */
    Integer select(selectTopic topic);
    /***
     * 查找有没有答过题
     */
    Integer count(response response);
}
