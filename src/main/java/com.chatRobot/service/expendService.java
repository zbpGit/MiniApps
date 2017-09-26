package com.chatRobot.service;

import com.chatRobot.model.expend;

/**
 * Created by V on 2017/9/20.
 * 支出服务层
 */
public interface expendService {
    /***
     * 添加支出
     * @param expend
     */
    void add(expend expend);

    /***
     * 修改支出
     */
    void update(expend expend);
}
