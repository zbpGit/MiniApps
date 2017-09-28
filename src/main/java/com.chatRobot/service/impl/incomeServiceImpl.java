package com.chatRobot.service.impl;

import com.chatRobot.dao.gameDao;
import com.chatRobot.dao.incomeDao;
import com.chatRobot.model.game;
import com.chatRobot.model.income;
import com.chatRobot.model.user;
import com.chatRobot.service.gameService;
import com.chatRobot.service.incomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/11.
 * 玩法服务层实现类
 */
@Service
public class incomeServiceImpl implements incomeService {
    @Resource
    private incomeDao dao;
    @Override
    public Integer selectIncome(Map map) {
        return dao.selectIncome(map);
    }

    @Override
    public void add(Map map) {
        dao.add(map);
    }

    @Override
    public  List<income> userIncome(Integer uid) {
        return dao.userIncome(uid);
    }

    @Override
    public List<user> selectUser(Integer id) {
        return dao.selectUser(id);
    }
}
