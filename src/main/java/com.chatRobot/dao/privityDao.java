package com.chatRobot.dao;

import com.chatRobot.model.privity;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/21.
 */
public interface privityDao {
    List<privity> select(Integer id);
    void add(Map map);
    privity selectPrivity(Map map);

    List<privity> rank(Integer id);
}
