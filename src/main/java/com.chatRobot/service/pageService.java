package com.chatRobot.service;

import com.chatRobot.model.page;

/**
 * Created by V on 2017/9/11.
 * 红包服务层
 */
public interface pageService {

    /***
     * 添加项目
     * @param page
     */
    void add(page page);

    /***
     * 设置项目
     * @param page
     */
    void update(page page);
}
