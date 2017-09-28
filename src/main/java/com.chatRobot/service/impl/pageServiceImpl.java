package com.chatRobot.service.impl;

import com.chatRobot.dao.pageDao;
import com.chatRobot.model.page;
import com.chatRobot.service.pageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Integer selectMoney(Integer id) {
        return dao.selectMoney(id);
    }

    @Override
    public Integer number(Integer id) {
        return dao.number(id);
    }

    @Override
    public String view(Integer id) {
        return dao.view(id);
    }

    @Override
    public String headline(Integer id) {
        return dao.headline(id);
    }

    @Override
    public List<page> pageSelect(Integer uid) {
        return dao.pageSelect(uid);
    }

    @Override
    public page selectNumber(Integer id) {
        return dao.selectNumber(id);
    }


}
