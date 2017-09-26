package com.chatRobot.dao;

import com.chatRobot.model.expend;

/**
 * Created by V on 2017/9/20.
 * 支出Dao层
 */
public interface expendDao {
    /***
     * 添加支出
     * @param expend
     */
    void add(expend expend);

    /***
     * 修改支出
     * @param expend
     */
    void update(expend expend);
}
