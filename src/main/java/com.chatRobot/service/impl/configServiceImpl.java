package com.chatRobot.service.impl;

import com.chatRobot.dao.configDao;
import com.chatRobot.dao.gameDao;
import com.chatRobot.service.configService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by V on 2017/9/11.
 * 配置服务层实现类
 */
@Service
public class configServiceImpl implements configService {
    @Resource
    private configDao dao;

    @Override
    public String select(String key) {
        return dao.select(key);
    }



}
