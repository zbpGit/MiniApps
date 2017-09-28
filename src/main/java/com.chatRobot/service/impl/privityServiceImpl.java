package com.chatRobot.service.impl;

import com.chatRobot.dao.privityDao;
import com.chatRobot.model.privity;
import com.chatRobot.service.privityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by V on 2017/9/21.
 * 默契度服务层实现类
 */
@Service
public class privityServiceImpl implements privityService {
    @Resource
    private privityDao dao;
    /***
     * 查出领红包用户的默契度跟相关信息
     * @param id
     * @return
     */
    @Override
    public List<privity> select(Integer id) {
        return dao.select(id);
    }

    @Override
    public void add(Map map) {
        dao.add(map);
    }

    @Override
    public privity selectPrivity(Map map) {
        return dao.selectPrivity(map);
    }

    @Override
    public List<privity> rank(Integer id) {
        return dao.rank(id);
    }
}
