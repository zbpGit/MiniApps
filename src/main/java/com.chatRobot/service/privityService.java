package com.chatRobot.service;

import com.chatRobot.model.privity;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/21.
 * 默契度服务层
 */
public interface privityService {
    /***
     * 查出领红包用户的默契度跟相关信息
     * @param id
     * @return
     */
    List<privity> select(Integer id);

    /***
     * 添加默契度信息
     * @param map
     */
    void add(Map map);

    privity selectPrivity(Map map);

    List<privity> rank(Integer id);

}
