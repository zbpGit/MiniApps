package com.chatRobot.dao;

import com.chatRobot.model.game;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 游戏Dao层
 */
public interface gameDao {
    List<game> select();
}
