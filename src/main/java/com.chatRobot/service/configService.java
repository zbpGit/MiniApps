package com.chatRobot.service;

import com.chatRobot.model.game;

import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 配置服务层
 */
public interface configService {
    /**
     * 查找配置
     * @return
     */
   String select(String key);
}
