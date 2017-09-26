package com.chatRobot.service.impl;

import com.chatRobot.dao.expendDao;
import com.chatRobot.model.expend;
import com.chatRobot.service.expendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by V on 2017/9/20.
 * 支出服务层
 */
@Service
public class expendServiceImpl implements expendService {
    @Resource
    private expendDao dao;

    /***
     * 添加支出
     * @param expend
     */
    @Override
    public void add(expend expend) {
        dao.add(expend);
    }

    /***
     * 修改支出
     */
    public void update(expend expend){
        dao.update(expend);
    }
}
