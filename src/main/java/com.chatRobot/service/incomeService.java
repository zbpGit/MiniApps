package com.chatRobot.service;

import com.chatRobot.model.game;
import com.chatRobot.model.income;
import com.chatRobot.model.user;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 收入服务层
 */
public interface incomeService {
    /**
     * 查找收入
     * @return
     */
    Integer selectIncome(Map map);

    /***
     * 添加收入
     * @param map
     */
    void add(Map map);

    /***
     * 查找所有收入
     * @param uid
     * @return
     */
    List<income> userIncome(Integer uid);

    /***
     * 查找用户跟收入
     * @param id
     * @return
     */
    List<user> selectUser(Integer id);
}
