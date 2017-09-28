package com.chatRobot.service.impl;

import com.chatRobot.dao.userDao;
import com.chatRobot.model.user;
import com.chatRobot.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by V on 2017/9/11.
 * 用户服务层实现类
 */
@Service
public class userServiceImpl implements userService {
    @Resource
    private userDao dao;

    /***
     * 添加用户
     * @param user
     */
    @Override
    public void add(user user) {
        dao.add(user);
    }

    /***
     * 跟距项目id查找发红包用户
     * @param id
     * @return
     */
    @Override
    public user select(Integer id) {
        return dao.select(id);
    }

    @Override
    public Integer selectUser(String openid) {
        return dao.selectUser(openid);
    }
}
