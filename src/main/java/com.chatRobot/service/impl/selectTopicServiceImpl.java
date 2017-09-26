package com.chatRobot.service.impl;

import com.chatRobot.dao.selectTopicDao;
import com.chatRobot.model.selectTopic;
import com.chatRobot.service.selectTopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by V on 2017/9/11.
 * 选题服务层实现
 */
@Service
public class selectTopicServiceImpl  implements selectTopicService {
    @Resource
    private selectTopicDao dao;

    /***
     * 添加已选题目
     * @param list
     */
    @Override
    public void add(List<selectTopic> list) {
        dao.add(list);
    }

    @Override
    public List<selectTopic> select(Integer tid) {
        return null;
    }

    @Override
    public Integer answer(Integer id) {
        return dao.answer(id);
    }


}
