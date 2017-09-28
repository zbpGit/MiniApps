package com.chatRobot.dao;

import com.chatRobot.model.game;
import com.chatRobot.model.income;
import com.chatRobot.model.user;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 收入Dao层
 */
public interface incomeDao {
    Integer selectIncome(Map map);

    void add(Map map);

    List<income> userIncome(Integer uid);

    List<user> selectUser(Integer id);

}
