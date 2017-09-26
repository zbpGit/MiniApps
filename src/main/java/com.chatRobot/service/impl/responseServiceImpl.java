package com.chatRobot.service.impl;

import com.chatRobot.dao.responseDao;
import com.chatRobot.model.response;
import com.chatRobot.model.selectTopic;
import com.chatRobot.service.responseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by V on 2017/9/21.
 * 答题服务层实现类
 */
@Service
public class responseServiceImpl implements responseService {
    @Resource
    private responseDao dao;

    /***
     * 提交答题
     * @param list
     */
    @Override
    public void add(List<response> list) {
        dao.add(list);
    }

    @Override
    public Integer select(selectTopic topic) {
        return dao.select(topic);
    }

    @Override
    public Integer count(response response) {
        return dao.count(response);
    }


}
