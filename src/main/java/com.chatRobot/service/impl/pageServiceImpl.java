package com.chatRobot.service.impl;

import com.chatRobot.dao.pageDao;
import com.chatRobot.model.page;
import com.chatRobot.service.pageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by V on 2017/9/11.
 * 红包服务层实现类
 */
@Service
public class pageServiceImpl implements pageService {
    @Resource
    private pageDao dao;

    /***
     * 添加项目
     * @param page
     */
    @Override
    public void add(page page) {
        dao.add(page);
    }

    /***
     * 设置项目
     * @param page
     */
    @Override
    public void update(page page) {
        dao.update(page);
    }


}
