package com.chatRobot.service.impl;

import com.chatRobot.model.game;
import com.chatRobot.service.gameService;
import com.chatRobot.dao.gameDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 玩法服务层实现类
 */
@Service
public class gameServiceImpl implements gameService {
    @Resource
    private gameDao dao;

    /***
     * 查找玩法
     * @return
     */
    @Override
    public List<game> select() {
        return dao.select();
    }
}
