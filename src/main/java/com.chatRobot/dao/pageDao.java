package com.chatRobot.dao;

import com.chatRobot.model.page;

/**
 * Created by V on 2017/9/11.
 * 项目Dao层
 */
public interface pageDao {
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
