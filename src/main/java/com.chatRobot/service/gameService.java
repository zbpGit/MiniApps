package com.chatRobot.service;

import com.chatRobot.model.game;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 玩法服务层
 */
public interface gameService {
    /**
     * 查找玩法
     * @return
     */
    List<game> select();
}
